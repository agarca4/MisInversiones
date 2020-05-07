import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { PieComponent } from './pie/pie.component';
import { HomeComponent } from './home/home.component';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NoDisponibleComponent } from './no-disponible/no-disponible.component';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [CabeceraComponent, PieComponent, HomeComponent, NoDisponibleComponent],
  imports: [
    CommonModule,
    MatIconModule, MatTableModule, MatFormFieldModule, MatInputModule, RouterModule, MatButtonModule,FormsModule
  ],
  exports: [CabeceraComponent, PieComponent, HomeComponent, MatIconModule, MatTableModule, MatFormFieldModule, MatInputModule, MatButtonModule,FormsModule]
})
export class ComunModule { }
