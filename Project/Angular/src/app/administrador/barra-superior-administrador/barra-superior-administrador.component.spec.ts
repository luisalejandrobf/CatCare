import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraSuperiorAdministradorComponent } from './barra-superior-administrador.component';

describe('BarraSuperiorAdministradorComponent', () => {
  let component: BarraSuperiorAdministradorComponent;
  let fixture: ComponentFixture<BarraSuperiorAdministradorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraSuperiorAdministradorComponent]
    });
    fixture = TestBed.createComponent(BarraSuperiorAdministradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
