import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraLateralClienteComponent } from './barra-lateral-cliente.component';

describe('BarraLateralClienteComponent', () => {
  let component: BarraLateralClienteComponent;
  let fixture: ComponentFixture<BarraLateralClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraLateralClienteComponent]
    });
    fixture = TestBed.createComponent(BarraLateralClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
