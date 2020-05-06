import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ComunModule } from './comun/comun.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarterasService } from './servicios/carteras.service';
import { CarterasLocalService } from './servicios/carteras-local.service';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './comun/home/home.component';
import { CarterasModule } from './carteras/carteras.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ComunModule,
    BrowserAnimationsModule,CarterasModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'carteras',
        loadChildren: './carteras/carteras.module#CarterasModule'
      },

    ])
  ],
  providers: [
    {
      provide: CarterasService, useClass: CarterasLocalService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
