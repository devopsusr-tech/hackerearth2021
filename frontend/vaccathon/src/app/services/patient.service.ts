import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Patient} from '../models/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllPatients(): Observable<Patient[]> {
     let test = this.httpClient.get<Patient[]>('/rest/findAllPatients');
     console.log(test);
     return test;
  }

  public getPatient(id: number): Observable<Patient> {
     return this.httpClient.get<Patient>('/rest/findAllPatients/${id}');
  }


  public getAPIVersion(): Observable<string> {
    return this.httpClient.get<string>('/rest/');
  }


}
