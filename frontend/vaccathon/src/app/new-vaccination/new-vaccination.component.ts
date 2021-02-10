import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import {PatientService} from '../services/patient.service';
import {Vaccination} from '../models/vaccination';
import {Patient} from '../models/patient';

@Component({
  selector: 'app-new-vaccination',
  templateUrl: './new-vaccination.component.html',
  styleUrls: ['./new-vaccination.component.scss']
})
export class NewVaccinationComponent implements OnInit {

  myControl = new FormControl();
  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions: Observable<string[]>;
  private patient: any;
  // model = new Vaccination();

  constructor(private patientService: PatientService) {
    this.filteredOptions = new Observable<string[]>();
  }

  ngOnInit(): void {
    this.patient = this._loadPatient(123);

    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  private _loadPatient(nationalInsuranceNumber: number): Observable<Patient> {
    return this.patientService.getPatient(nationalInsuranceNumber);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  setValue(): void {
    //
  }

}
