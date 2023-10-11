import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaVeterinarioComponent } from './tabla-veterinario.component';

describe('TablaVeterinarioComponent', () => {
  let component: TablaVeterinarioComponent;
  let fixture: ComponentFixture<TablaVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaVeterinarioComponent]
    });
    fixture = TestBed.createComponent(TablaVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
