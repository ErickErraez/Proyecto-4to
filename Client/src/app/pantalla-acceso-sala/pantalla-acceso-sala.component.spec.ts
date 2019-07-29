import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PantallaAccesoSalaComponent } from './pantalla-acceso-sala.component';

describe('PantallaAccesoSalaComponent', () => {
  let component: PantallaAccesoSalaComponent;
  let fixture: ComponentFixture<PantallaAccesoSalaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PantallaAccesoSalaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PantallaAccesoSalaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
