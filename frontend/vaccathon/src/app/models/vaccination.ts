import {VaccinationTemplate} from "./vaccinationTemplate";
import {Doctor} from "./doctor";

export class Vaccination {

  constructor(
    public template: VaccinationTemplate,
    public applicationDate: Date,
    public  doctor: Doctor,
    public expirationDate: Date
  ) {
  }
}
