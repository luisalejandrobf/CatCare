import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableroDatosAdministradorComponent } from './tablero-datos-administrador.component';

describe('TableroDatosAdministradorComponent', () => {
  let component: TableroDatosAdministradorComponent;
  let fixture: ComponentFixture<TableroDatosAdministradorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TableroDatosAdministradorComponent]
    });
    fixture = TestBed.createComponent(TableroDatosAdministradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
