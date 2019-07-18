import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PantallaHacerPreguntaComponent } from './pantalla-hacer-pregunta.component';

describe('PantallaHacerPreguntaComponent', () => {
  let component: PantallaHacerPreguntaComponent;
  let fixture: ComponentFixture<PantallaHacerPreguntaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PantallaHacerPreguntaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PantallaHacerPreguntaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
