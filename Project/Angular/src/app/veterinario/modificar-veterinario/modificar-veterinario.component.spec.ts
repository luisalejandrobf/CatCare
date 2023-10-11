import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarVeterinarioComponent } from './modificar-veterinario.component';

describe('ModificarVeterinarioComponent', () => {
  let component: ModificarVeterinarioComponent;
  let fixture: ComponentFixture<ModificarVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModificarVeterinarioComponent]
    });
    fixture = TestBed.createComponent(ModificarVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

