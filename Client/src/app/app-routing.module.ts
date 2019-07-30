import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearSalaComponent } from './crear-sala/crear-sala.component';
import { PantallaAccesoSalaComponent } from './pantalla-acceso-sala/pantalla-acceso-sala.component';
import { PantallaHacerPreguntaComponent } from './pantalla-hacer-pregunta/pantalla-hacer-pregunta.component';
import { RegistroExpositorComponent } from './registro-expositor/registro-expositor.component';
import { PantallaPreguntasComponent } from './pantalla-preguntas/pantalla-preguntas.component';
import { InicioComponent } from './inicio/inicio.component';


const routes: Routes = [
  { path: 'crear-sala', component: CrearSalaComponent },
  { path: 'acceso', component: PantallaAccesoSalaComponent },
  { path: 'formular-pregunta/:codigo', component: PantallaHacerPreguntaComponent },
  { path: 'registro-expositor', component: RegistroExpositorComponent },
  { path: 'listado-preguntas', component: PantallaPreguntasComponent },
  { path: 'inicio', component: InicioComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
