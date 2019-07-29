import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearSalaComponent } from './crear-sala/crear-sala.component';
import { PantallaAccesoSalaComponent } from './pantalla-acceso-sala/pantalla-acceso-sala.component';
import { PantallaHacerPreguntaComponent } from './pantalla-hacer-pregunta/pantalla-hacer-pregunta.component';
import { RegistroExpositorComponent } from './registro-expositor/registro-expositor.component';
import { PantallaPreguntasComponent } from './pantalla-preguntas/pantalla-preguntas.component';
import { InicioComponent } from './inicio/inicio.component';
import { RegistroUsuarioComponent } from './registro-usuario/registro-usuario.component';

const routes: Routes = [
  { path: 'crear-sala', component: CrearSalaComponent },
  { path: 'acceso', component: PantallaAccesoSalaComponent },
  { path: 'preguntar', component: PantallaHacerPreguntaComponent },
  { path: 'registro-expositor', component: RegistroExpositorComponent },
  { path: 'registro-usuario', component: RegistroUsuarioComponent },
  { path: 'preguntas', component: PantallaPreguntasComponent },
  { path: 'inicio', component: InicioComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
