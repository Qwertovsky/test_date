export class TestEntity {
  public id: number | undefined;
  public zoneId: string;
  public testDate: Date;

  public constructor(date: Date, zoneId: string) {
    this.testDate = date;
    this.zoneId = zoneId;
  }
}