import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FavoritoComponent } from './favorito/favorito.component';
import { MatIconModule} from '@angular/material/icon'



@NgModule({
  declarations: [FavoritoComponent],
  imports: [
    CommonModule,
    MatIconModule
  ],
  exports: [FavoritoComponent]
})
export class ComponentesReusablesModule { }
