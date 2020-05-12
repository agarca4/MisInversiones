import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { AppComponent } from './app.component';
import { ComunModule } from './comun/comun.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarterasService } from './servicios/carteras.service';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './comun/home/home.component';
import { CarterasApiService } from './servicios/carteras-api.service';
import { HttpClientModule } from '@angular/common/http';

import { ManejadorError } from './comun/manejador-error';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ComunModule,
    BrowserAnimationsModule,HttpClientModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'carteras',
        loadChildren: () => import('./carteras/carteras.module').then(mod => mod.CarterasModule) 
      },

    ])
  ],
  providers: [
    {
      provide: CarterasService, useClass: CarterasApiService
    },
    {
      provide: ErrorHandler, useClass: ManejadorError
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
