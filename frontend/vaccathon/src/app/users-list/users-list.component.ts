import {Component, OnInit} from '@angular/core';
import {PatientService} from "../services/patient.service";
import {Patient} from "../models/patient";
import {Router} from "@angular/router";

export interface PatientTableElement {
  firstName: string;
  lastName: string;
  email: string;
  nationalInsuranceNumber: number;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  patients: Patient[] = [];

  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'nationalInsuranceNumber'];
  patientTableElements: PatientTableElement[] = []


  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe((patients) => {
      this.patients = patients;
      let array: PatientTableElement[] = []
      patients.forEach(patient => {
        array.push({
          nationalInsuranceNumber: patient.nationalInsuranceNumber,
          firstName: patient.firstName,
          lastName: patient.lastName,
          email: patient.email
        })
      })
      this.patientTableElements = array
    }, error => {
      console.error(error);
    });
  }

  navigateToPatient(securityNumber: number) {
    this.router.navigate(['/patient/'+ securityNumber]);
  }

}
