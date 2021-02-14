import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VaccinationTemplate} from '../models/vaccinationTemplate';
import {Vaccination} from '../models/vaccination';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllVaccinationTemplates(): Observable<VaccinationTemplate[]> {
    return this.httpClient.get<VaccinationTemplate[]>('/rest/findAllVaccinationTemplates');
  }

  public saveVaccination(vaccination: Vaccination, nationalInsuranceNumber: number): Observable<any> {

    const headers = {'content-type': 'application/json'};
    const body = JSON.stringify(vaccination);

    return this.httpClient.post<Vaccination>('/rest/createVaccination/pid/' + nationalInsuranceNumber, body, {'headers': headers});
  }
}
