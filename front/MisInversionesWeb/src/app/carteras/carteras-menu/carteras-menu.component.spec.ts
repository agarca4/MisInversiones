import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarterasMenuComponent } from './carteras-menu.component';

describe('CarterasMenuComponent', () => {
  let component: CarterasMenuComponent;
  let fixture: ComponentFixture<CarterasMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarterasMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarterasMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
