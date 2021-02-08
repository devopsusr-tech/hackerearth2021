import {Vaccination} from "./vaccination";
import {Person} from "./person";

export class Patient extends Person{

  constructor(
    public vaccinationList: Vaccination[] = [],
    public  nationalInsuranceNumber: number,
    public  firstName: string,
    public  lastName: string,
    public  birthDay: Date,
    public  email: string,
    public  phone: string,
    public  city: string
  ) {
    super(nationalInsuranceNumber,
      firstName,
      lastName,
      birthDay,
      email,
      phone,
      city);
  }


}
