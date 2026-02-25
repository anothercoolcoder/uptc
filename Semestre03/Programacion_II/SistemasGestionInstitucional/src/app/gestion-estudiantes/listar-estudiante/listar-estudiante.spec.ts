import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEstudiante } from './listar-estudiante';

describe('ListarEstudiante', () => {
  let component: ListarEstudiante;
  let fixture: ComponentFixture<ListarEstudiante>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarEstudiante]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarEstudiante);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
