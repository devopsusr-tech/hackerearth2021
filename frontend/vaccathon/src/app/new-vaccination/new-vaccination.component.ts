import {Component, Input, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {VaccinationService} from '../services/vaccination.service';
import {DoctorService} from '../services/doctor.service';
import {VaccinationTemplate} from '../models/vaccinationTemplate';
import {Location} from '@angular/common';
import {Doctor} from '../models/doctor';
import {Vaccination} from '../models/vaccination';
import {NgForm} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

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
  private productNumber = 0;

  constructor(private route: ActivatedRoute,
              private vaccinationService: VaccinationService,
              private doctorService: DoctorService,
              private location: Location) {
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.productNumber = params.id;
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
    this.vaccination.productNumber = this.productNumber;
    const result = this.vaccinationService.saveVaccination(this.vaccination);
    if (result) {
      window.alert('The new vaccine has been added to the history!');
    } else {

    }
  }

  cancelClicked(): void {
    this.location.back();
  }

}
