import {Component, OnInit} from '@angular/core';
import {PatientService} from "../services/patient.service";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";

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
export class UserProfileComponent implements OnInit {
  private routeSub: Subscription | null = null;
  apiVersion = '';
  test = '';

  constructor(private patientService: PatientService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.test = params['id'];
    });


    this.patientService.getAPIVersion().subscribe((version) => {
      console.log('API version: ', version);
      this.apiVersion = version;
    }, error => {
      console.error(error);
    });
  }

  ngOnDestroy() {
    this.routeSub?.unsubscribe();
  }

}
