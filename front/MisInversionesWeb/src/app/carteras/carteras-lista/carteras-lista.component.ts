import { Component, OnInit } from '@angular/core';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { Cartera } from './../../modelo/cartera'

@Component({
  selector: 'app-carteras-lista',
  templateUrl: './carteras-lista.component.html',
  styleUrls: ['./carteras-lista.component.css']
})
export class CarterasListaComponent implements OnInit {


  carterasLista: Cartera[];

  constructor(private carterasService: CarterasService) {
  }

  ngOnInit() {
    this.carterasService.getCarteras().subscribe(
      respuesta => (this.carterasLista = respuesta)
    )
   
  }

  isRentabilidadNegativa(cartera) {
    if (cartera.rentabilidad < 0) {
      return true;
    }
  }

  filtrar(filtro?) {
    if (!filtro || filtro.trim().length == 0) {
      this.carterasService.getCarteras().subscribe(
        respuesta => (this.carterasLista = respuesta)
      )
    } else {
      this.carterasService.getCarterasConNombre(filtro).subscribe(
        respuesta => (this.carterasLista = respuesta)
      )
    }
  }

}
