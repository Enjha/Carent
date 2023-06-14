import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarCreateComponent } from './car-create.component';

describe('CarCreateComponent', () => {
  let component: CarCreateComponent;
  let fixture: ComponentFixture<CarCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarCreateComponent]
    });
    fixture = TestBed.createComponent(CarCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
