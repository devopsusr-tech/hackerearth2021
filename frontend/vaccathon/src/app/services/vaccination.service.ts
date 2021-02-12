import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VaccinationTemplate} from '../models/vaccinationTemplate';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllVaccinationTemplates(): Observable<VaccinationTemplate[]> {
    return this.httpClient.get<VaccinationTemplate[]>('/rest/findAllVaccinationTemplates');
  }
}
