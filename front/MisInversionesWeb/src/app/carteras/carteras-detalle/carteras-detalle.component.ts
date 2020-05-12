import { Component, OnInit } from '@angular/core';
import { Cartera } from 'src/app/modelo/cartera';
import { CarterasService } from 'src/app/servicios/carteras.service';

@Component({
  selector: 'app-carteras-detalle',
  templateUrl: './carteras-detalle.component.html',
  styleUrls: ['./carteras-detalle.component.css']
})
export class CarterasDetalleComponent implements OnInit {

  idCartera = "23";
  cartera: Cartera = {
    nombre: null,
    fechaCreacionCartera: null,
    capitalInvertido: null,
    rentabilidad: null
  };

  constructor(private carterasService: CarterasService) { }

  ngOnInit() {
    this.carterasService.getCarteraPorId(this.idCartera).subscribe(
      respuesta => this.cartera = respuesta
    )
  }

}
