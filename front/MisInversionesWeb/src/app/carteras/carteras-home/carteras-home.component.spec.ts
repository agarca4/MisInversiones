import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarterasHomeComponent } from './carteras-home.component';

describe('CarterasHomeComponent', () => {
  let component: CarterasHomeComponent;
  let fixture: ComponentFixture<CarterasHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarterasHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarterasHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
