import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraSuperiorClienteComponent } from './barra-superior-cliente.component';

describe('BarraSuperiorClienteComponent', () => {
  let component: BarraSuperiorClienteComponent;
  let fixture: ComponentFixture<BarraSuperiorClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraSuperiorClienteComponent]
    });
    fixture = TestBed.createComponent(BarraSuperiorClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
