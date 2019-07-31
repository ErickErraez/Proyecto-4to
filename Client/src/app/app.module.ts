import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { QRCodeModule } from 'angularx-qrcode';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrearSalaComponent } from './crear-sala/crear-sala.component';
import { RegistroExpositorComponent } from './registro-expositor/registro-expositor.component';
import { PantallaPreguntasComponent } from './pantalla-preguntas/pantalla-preguntas.component';
import { PantallaAccesoSalaComponent } from './pantalla-acceso-sala/pantalla-acceso-sala.component';
import { PantallaHacerPreguntaComponent } from './pantalla-hacer-pregunta/pantalla-hacer-pregunta.component';
import { InicioComponent } from './inicio/inicio.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CronometroComponent } from './cronometro/cronometro.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearSalaComponent,
    RegistroExpositorComponent,
    PantallaPreguntasComponent,
    PantallaAccesoSalaComponent,
    PantallaHacerPreguntaComponent,
    InicioComponent,
    NavbarComponent,
    CronometroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    QRCodeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
