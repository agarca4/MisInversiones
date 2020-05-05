import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FondosFormComponent } from './fondos-form.component';

describe('FondosFormComponent', () => {
  let component: FondosFormComponent;
  let fixture: ComponentFixture<FondosFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FondosFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FondosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
