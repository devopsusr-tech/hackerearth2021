import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {VaccinationService} from '../services/vaccination.service';
import {DoctorService} from '../services/doctor.service';
import {VaccinationTemplate} from '../models/vaccinationTemplate';
import {Location} from '@angular/common';
import {Doctor} from '../models/doctor';

@Component({
  selector: 'app-new-vaccination',
  templateUrl: './new-vaccination.component.html',
  styleUrls: ['./new-vaccination.component.scss']
})
export class NewVaccinationComponent implements OnInit {

  vaccinationTemplateOptions: VaccinationTemplate[] = [];
  doctorOptions: Doctor[] = [];

  constructor(private vaccinationService: VaccinationService, private doctorService: DoctorService, private location: Location) {
  }

  ngOnInit(): void {
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

  saveNewVaccination(): void {
    //
  }

  cancelClicked(): void {
    this.location.back();
  }

}
