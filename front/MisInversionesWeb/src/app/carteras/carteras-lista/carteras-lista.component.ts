import { Component, OnInit } from '@angular/core';
import { CarterasService } from 'src/app/servicios/carteras.service';

@Component({
  selector: 'app-carteras-lista',
  templateUrl: './carteras-lista.component.html',
  styleUrls: ['./carteras-lista.component.css']
})
export class CarterasListaComponent implements OnInit {


  carterasLista;



  //aquí meto la dependencia del tipo de la interfaz (clase abstracta)
  //en el app.module, ya le digo cul tiene q usar, si la local o la de la api
  constructor(private carterasService: CarterasService) {
  }

  ngOnInit(): void {
    this.carterasLista = this.carterasService.getCarteras();
  }

  isRentabilidadNegativa(cartera) {
    if (cartera.rentabilidad < 0) {
      return true;
    }
  }

  filtrar(filtro){
    if (!filtro || filtro.trim().length == 0) {
      this.carterasLista = this.carterasService.getCarteras();
    }else{
      this.carterasLista = this.carterasService.getCarterasConNombre(filtro);
    }
  }

}
