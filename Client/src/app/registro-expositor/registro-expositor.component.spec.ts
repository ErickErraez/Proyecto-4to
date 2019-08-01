import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroExpositorComponent } from './registro-expositor.component';

describe('RegistroExpositorComponent', () => {
  let component: RegistroExpositorComponent;
  let fixture: ComponentFixture<RegistroExpositorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistroExpositorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistroExpositorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
