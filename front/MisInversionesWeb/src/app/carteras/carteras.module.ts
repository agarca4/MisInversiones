import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarterasListaComponent } from './carteras-lista/carteras-lista.component';
import { ComunModule } from '../comun/comun.module';
import { RouterModule } from '@angular/router';
import { CarterasFormComponent } from './carteras-form/carteras-form.component';
import { CarterasDetalleComponent } from './carteras-detalle/carteras-detalle.component';
import { UsuariosFormComponent } from './usuarios-form/usuarios-form.component';
import { CarterasHomeComponent } from './carteras-home/carteras-home.component';
import { CarterasMenuComponent } from './carteras-menu/carteras-menu.component';



@NgModule({
  declarations: [CarterasListaComponent, CarterasFormComponent, CarterasDetalleComponent, UsuariosFormComponent, CarterasHomeComponent, CarterasMenuComponent],
  imports: [
    CommonModule, ComunModule,
    RouterModule.forChild([
      {
        path: '',
        component: CarterasHomeComponent,
        children: [
          {
            path: '',
            component: CarterasListaComponent
          },
          {
            path: 'form/:id',
            component: CarterasFormComponent
          },
          {
            path: 'form',
            component: CarterasFormComponent
          },
          {
            path: 'detalle',
            component: CarterasDetalleComponent
          }

        ]
      }
    ])
  ],
 
})
export class CarterasModule { }
