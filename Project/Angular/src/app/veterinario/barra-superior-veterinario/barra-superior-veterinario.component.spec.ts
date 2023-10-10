import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraSuperiorVeterinarioComponent } from './barra-superior-veterinario.component';

describe('BarraSuperiorVeterinarioComponent', () => {
  let component: BarraSuperiorVeterinarioComponent;
  let fixture: ComponentFixture<BarraSuperiorVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraSuperiorVeterinarioComponent]
    });
    fixture = TestBed.createComponent(BarraSuperiorVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
