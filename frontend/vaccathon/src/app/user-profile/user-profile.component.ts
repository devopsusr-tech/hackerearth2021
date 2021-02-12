import {Component, OnDestroy, OnInit} from '@angular/core';
import {PatientService} from '../services/patient.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';
import {Patient} from '../models/patient';
import {Location} from '@angular/common';

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
  displayedColumns: any;

  constructor(private patientService: PatientService, private route: ActivatedRoute, private location: Location) {
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

  backClicked(): void {
    this.location.back();
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }

}
