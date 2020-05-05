import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarterasFormComponent } from './carteras-form.component';

describe('CarterasFormComponent', () => {
  let component: CarterasFormComponent;
  let fixture: ComponentFixture<CarterasFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarterasFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarterasFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
