import { Component, OnInit } from '@angular/core';
import { Cartera } from 'src/app/modelo/cartera';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-carteras-detalle',
  templateUrl: './carteras-detalle.component.html',
  styleUrls: ['./carteras-detalle.component.css']
})
export class CarterasDetalleComponent implements OnInit {

  idCartera;
  cartera: Cartera = {
    nombre: null,
    fechaCreacionCartera: null,
    capitalInvertido: 0.0,
    rentabilidad: 0.0
  };

  fondos = [
    {
      nombre: null,
      sector: null,
      tipo: null,
      riesgo: null,
      capitalInvertido: 0.0

    }
  ];

  constructor(
    private carterasService: CarterasService,
    private ruta: ActivatedRoute
    ) { }

  ngOnInit() {
    
this.idCartera = this.ruta.snapshot.paramMap.get('id');

    
    
    this.carterasService.getCarteraPorId(this.idCartera).subscribe(
      respuesta => this.cartera = respuesta
    )

    this.carterasService.getFondosPorCartera(this.idCartera).subscribe(
      respuesta => {
        this.fondos = respuesta
      }
    )



  }

}
