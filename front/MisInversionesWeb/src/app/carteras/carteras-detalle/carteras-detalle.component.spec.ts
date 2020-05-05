import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarterasDetalleComponent } from './carteras-detalle.component';

describe('CarterasDetalleComponent', () => {
  let component: CarterasDetalleComponent;
  let fixture: ComponentFixture<CarterasDetalleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarterasDetalleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarterasDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
