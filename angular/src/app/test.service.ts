import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map} from 'rxjs/operators'; 
import { TestEntity } from './test_entity';
import { Observable } from 'rxjs';

const CONTROLLER = 'http://localhost:8080/test';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }

  public saveEntity(entity: TestEntity): Observable<number> {
    const date: Date = entity.testDate;
    const testDate: string = [date.getFullYear(), date.getMonth() + 1, date.getDate()]
      .map(n => String(n).padStart(2, '0')).join('-')
      + 'T' + [date.getHours(), date.getMinutes(), date.getSeconds()]
      .map(n => String(n).padStart(2, '0')).join(':');
    const body: any = Object.assign({}, entity, {testDate});
    return this.http.post<number>(CONTROLLER, body);
  }

  public getEntities(): Observable<TestEntity[]> {
    return this.http.get<any[]>(CONTROLLER + '/all')
    .pipe(
      map((objs: any[]) => {
        return objs.map(this.mapEntity);
      })
    );
  }

  public getEntity(id: number): Observable<TestEntity> {
    return this.http.get<any>(CONTROLLER + '?id=' + id)
    .pipe(
      map(this.mapEntity)
    );
  }

  private mapEntity(obj: any): TestEntity {
    const date: Date = new Date(obj.testDate);
    const entity = new TestEntity(date);
    entity.id = obj.id;
    return entity;
  }
}
