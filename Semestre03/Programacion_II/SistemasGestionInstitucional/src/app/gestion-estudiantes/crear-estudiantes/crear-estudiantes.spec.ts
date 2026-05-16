import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearEstudiantes } from './crear-estudiantes';

describe('CrearEstudiantes', () => {
  let component: CrearEstudiantes;
  let fixture: ComponentFixture<CrearEstudiantes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearEstudiantes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearEstudiantes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
