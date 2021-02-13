import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Doctor} from '../models/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllDoctors(): Observable<Doctor[]> {
    return this.httpClient.get<Doctor[]>('/rest/findAllDoctors');
  }

  public getDoctor(id: string): Observable<Doctor> {
    return this.httpClient.get<Doctor>('/rest/findAllDoctors/' + id);
  }

  public getAPIVersion(): Observable<string> {
    return this.httpClient.get<string>('/rest/');
  }
}
