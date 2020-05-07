import { Injectable } from '@angular/core';
import { CarterasService } from './carteras.service';
import { Cartera } from '../modelo/cartera';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarterasApiService extends CarterasService {

  constructor(private http: HttpClient) {
    super();
  }

  getCarteras(): Observable<Cartera[]> {
    return this.http.get('http://localhost:8081/api/carteras');

  }






  getCarterasConNombre(filtro: any): Cartera[] {
    throw new Error("Method not implemented.");
  }
  crearCartera(cartera: Cartera) {
    throw new Error("Method not implemented.");
  }
  getCarteraPorId(id: any): Cartera {
    throw new Error("Method not implemented.");
  }
  modificarCartera(id: string, cartera: Cartera) {
    throw new Error("Method not implemented.");
  }


}
