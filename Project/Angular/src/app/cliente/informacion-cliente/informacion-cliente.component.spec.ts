import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformacionClienteComponent } from './informacion-cliente.component';

describe('InformacionClienteComponent', () => {
  let component: InformacionClienteComponent;
  let fixture: ComponentFixture<InformacionClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InformacionClienteComponent]
    });
    fixture = TestBed.createComponent(InformacionClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
