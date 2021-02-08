import {Person} from "./person";

export class Doctor extends Person {

  constructor(
    public  hospital: string,
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
