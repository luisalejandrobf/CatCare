import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TratamientoComponent } from './tratamiento.component';

describe('TratamientoComponent', () => {
  let component: TratamientoComponent;
  let fixture: ComponentFixture<TratamientoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TratamientoComponent]
    });
    fixture = TestBed.createComponent(TratamientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
