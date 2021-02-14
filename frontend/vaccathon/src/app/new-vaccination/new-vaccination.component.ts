import {Component, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {VaccinationService} from '../services/vaccination.service';
import {DoctorService} from '../services/doctor.service';
import {PatientService} from '../services/patient.service';
import {VaccinationTemplate} from '../models/vaccinationTemplate';
import {Location} from '@angular/common';
import {Doctor} from '../models/doctor';
import {Vaccination} from '../models/vaccination';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-new-vaccination',
  templateUrl: './new-vaccination.component.html',
  styleUrls: ['./new-vaccination.component.scss']
})
export class NewVaccinationComponent implements OnInit {
  private routeSub: Subscription | null = null;
  vaccination: Vaccination = {} as Vaccination;
  vaccinationTemplateOptions: VaccinationTemplate[] = [];
  doctorOptions: Doctor[] = [];
  private nationalInsuranceNumber = 0;

  constructor(private route: ActivatedRoute,
              private vaccinationService: VaccinationService,
              private doctorService: DoctorService,
              private patientService: PatientService,
              private location: Location,
              private router: Router) {
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.nationalInsuranceNumber = params.id;
    });
    this._loadAllVaccinationTemplates().subscribe(templates => {
      this.vaccinationTemplateOptions = templates as VaccinationTemplate[];
    });
    this._loadAllDoctors().subscribe(doctor => {
      this.doctorOptions = doctor as Doctor[];
    });
  }

  private _loadAllVaccinationTemplates(): Observable<VaccinationTemplate[]> {
    return this.vaccinationService.getAllVaccinationTemplates();
  }

  private _loadAllDoctors(): Observable<Doctor[]> {
    return this.doctorService.getAllDoctors();
  }

  onSubmit(f: NgForm): void {
    this.vaccination = f.value;
    this.vaccinationService.saveVaccination(this.vaccination, this.nationalInsuranceNumber).subscribe({
      next: data => {
        this.putVaccinationIntoPatientHistory(this.nationalInsuranceNumber, data);
      },
      error: error => {
        console.error('There was an error!', error);
        window.alert('Unfortunately the request was failed. Please try again!');
      }
    });
  }

  private putVaccinationIntoPatientHistory(nationalInsuranceNumber: number, vaccination: Vaccination): void {
    this.patientService.updateVaccinationHistoryOfPatient(nationalInsuranceNumber, vaccination.productNumber).subscribe({
      next: data => {
        console.log('It was succeed!', data);
        this.router.navigate(['/patient/' + this.nationalInsuranceNumber]);
      },
      error: error => {
        console.error('There was an error!', error);
        window.alert('Unfortunately the request was failed. Please try again!');
      }
    });
  }

  cancelClicked(): void {
    this.location.back();
  }

}
