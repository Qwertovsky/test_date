import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs/operators'; 
import { TestService } from '../test.service';
import { TestEntity } from '../test_entity';

@Component({
  selector: 'test-entities',
  templateUrl: './test-entities.component.html',
  styleUrls: ['./test-entities.component.scss']
})
export class TestEntitiesComponent implements OnInit {

  public entities: TestEntity[] = [];
  public dateValue: Date | undefined = new Date();
  public message: string | undefined;

  constructor(private testService: TestService) {
    this.testService.getEntities()
    .pipe(
      tap((es) => {
        es.forEach((e) => console.log(e));
      })
    )
    .subscribe((es) => {
      this.entities = es;
    })
  }

  ngOnInit(): void {
  }

  public saveEntity(): void {
    if (this.dateValue == undefined) {
      this.message = 'Date not selected';
      return;
    }
    const newEntity = new TestEntity(this.dateValue);
    this.testService.saveEntity(newEntity)
    .subscribe((id) => {
      newEntity.id = id;
      this.message = 'Saved as ' + this.dateValue;
      this.dateValue = undefined;
      this.testService.getEntity(id)
      .subscribe((e) => {
        this.entities.push(e);
      });
    },
    (res: HttpErrorResponse) => {
      this.message = res.message;
    });
  }

}
