import {Component, OnDestroy, OnInit} from '@angular/core';
import {PatientService} from '../services/patient.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';
import {Patient} from "../models/patient";

export interface PatientTableElement {
  firstName: string;
  lastName: string;
  email: string;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit, OnDestroy {
  private routeSub: Subscription | null = null;
  apiVersion = '';
  patient: Patient | undefined = undefined;

  constructor(private patientService: PatientService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      const userId = params.id;
      this.patientService.getPatient(userId).subscribe((patient) => {
        this.patient = patient;
      });
    });

    this.patientService.getAPIVersion().subscribe((version) => {
      console.log('API version: ', version);
      this.apiVersion = version;
    }, error => {
      console.error(error);
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }

}
