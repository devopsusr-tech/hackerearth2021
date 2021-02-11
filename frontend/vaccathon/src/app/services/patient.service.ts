import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Patient} from '../models/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllPatients(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>('/rest/findAllPatients');
  }

  public getPatient(id: string): Observable<Patient> {
    return this.httpClient.get<Patient>('/rest/findAllPatients/' + id);
  }

  public getAPIVersion(): Observable<string> {
    return this.httpClient.get<string>('/rest/');
  }
}
