import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestEntitiesComponent } from './test-entities.component';

describe('TestEntitiesComponent', () => {
  let component: TestEntitiesComponent;
  let fixture: ComponentFixture<TestEntitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestEntitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestEntitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
