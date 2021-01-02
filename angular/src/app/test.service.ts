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
    return this.http.post<number>(CONTROLLER, entity);
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
    const entity = new TestEntity(new Date(obj.testDate), "");
    entity.id = obj.id;
    return entity;
  }
}
