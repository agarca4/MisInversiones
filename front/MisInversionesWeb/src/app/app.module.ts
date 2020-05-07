import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ComunModule } from './comun/comun.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarterasService } from './servicios/carteras.service';
import { CarterasLocalService } from './servicios/carteras-local.service';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './comun/home/home.component';
import { CarterasApiService } from './servicios/carteras-api.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ComunModule,
    BrowserAnimationsModule,
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
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
