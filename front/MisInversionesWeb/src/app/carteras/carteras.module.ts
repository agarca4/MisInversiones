import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarterasListaComponent } from './carteras-lista/carteras-lista.component';
import { ComunModule } from '../comun/comun.module';
import { RouterModule } from '@angular/router';
import { CarterasFormComponent } from './carteras-form/carteras-form.component';
import { CarterasDetalleComponent } from './carteras-detalle/carteras-detalle.component';
import { CarterasHomeComponent } from './carteras-home/carteras-home.component';
import { CarterasMenuComponent } from './carteras-menu/carteras-menu.component';




@NgModule({
  declarations: [CarterasListaComponent, CarterasFormComponent, CarterasDetalleComponent, CarterasHomeComponent, CarterasMenuComponent],
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
            path: ':id',
            component: CarterasDetalleComponent
          },

        ]
      }
    ])
  ],
  exports:[CarterasListaComponent]
 
})
export class CarterasModule { }
