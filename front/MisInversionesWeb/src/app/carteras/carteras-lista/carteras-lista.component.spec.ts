import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarterasListaComponent } from './carteras-lista.component';

describe('CarterasListaComponent', () => {
  let component: CarterasListaComponent;
  let fixture: ComponentFixture<CarterasListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarterasListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarterasListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
