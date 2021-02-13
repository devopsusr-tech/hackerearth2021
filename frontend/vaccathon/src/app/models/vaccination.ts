import {VaccinationTemplate} from './vaccinationTemplate';
import {Doctor} from './doctor';

export class Vaccination {

  constructor(
    public productNumber: number,
    public template: VaccinationTemplate,
    public applicationDate: Date,
    public doctor: Doctor,
    public expirationDate: Date,
    public remark: string
  ) {
  }
}
