import {Component, OnInit} from '@angular/core';
import {PatientService} from "../services/patient.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  apiVersion = '';

  constructor(private patientService: PatientService) {
  }

  ngOnInit(): void {
    this.patientService.getAPIVersion().subscribe((version) => {
      console.log('API version: ', version);
      this.apiVersion = version;
    }, error => {
      console.error(error);
    });
  }


}
