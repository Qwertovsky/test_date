export class TestEntity {
  public id: number | undefined;
  public testDate: Date;

  public constructor(date: Date) {
    this.testDate = date;
  }
}