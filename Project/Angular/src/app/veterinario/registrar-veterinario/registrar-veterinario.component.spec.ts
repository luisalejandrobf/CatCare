import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarVeterinarioComponent } from './registrar-veterinario.component';

describe('RegistrarVeterinarioComponent', () => {
  let component: RegistrarVeterinarioComponent;
  let fixture: ComponentFixture<RegistrarVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrarVeterinarioComponent]
    });
    fixture = TestBed.createComponent(RegistrarVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
