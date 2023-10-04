import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrogaComponent } from './droga.component';

describe('DrogaComponent', () => {
  let component: DrogaComponent;
  let fixture: ComponentFixture<DrogaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrogaComponent]
    });
    fixture = TestBed.createComponent(DrogaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
