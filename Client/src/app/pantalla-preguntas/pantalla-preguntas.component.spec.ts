import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PantallaPreguntasComponent } from './pantalla-preguntas.component';

describe('PantallaPreguntasComponent', () => {
  let component: PantallaPreguntasComponent;
  let fixture: ComponentFixture<PantallaPreguntasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PantallaPreguntasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PantallaPreguntasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
