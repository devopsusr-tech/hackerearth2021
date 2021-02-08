export class VaccinationTemplate {

  constructor(
    public id: number,
    public description: string,
    public  sideEffects: string,
    public  company: string,
    public  effectDuration: number,
    public  type: string,
    public  targetGroup: string
  ) {
  }
}
