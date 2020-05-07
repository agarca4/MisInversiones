import { Injectable } from '@angular/core';
import { CarterasService } from './carteras.service';
import { carteras_data } from "./../data/carteras.data";
import { Cartera } from '../modelo/cartera';


@Injectable()
export class CarterasLocalService extends CarterasService {

  carteras = carteras_data;

  constructor() {
    super();
  }

  getCarteras() {
    return this.carteras;
  }

  getCarterasConNombre(filtro){
    return this.carteras.filter(
      (cartera)=>{
        let contieneNombre = cartera.nombreCartera.toUpperCase().includes(filtro.toUpperCase());
        return contieneNombre;
      }
    )
  }
  crearCartera(cartera){
    this.carteras.push(cartera);
  }
  
  getCarteraPorId(id): Cartera{
    return this.carteras[id];
  }

  modificarCartera(id: string, cartera: Cartera){
    this.carteras[id] = cartera;

  }


}
