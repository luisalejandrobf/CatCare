import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TratamientoPacienteComponent } from './tratamiento-paciente.component';

describe('TratamientoPacienteComponent', () => {
  let component: TratamientoPacienteComponent;
  let fixture: ComponentFixture<TratamientoPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TratamientoPacienteComponent]
    });
    fixture = TestBed.createComponent(TratamientoPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
