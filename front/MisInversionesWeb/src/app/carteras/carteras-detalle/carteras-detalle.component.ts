import { Component, OnInit } from '@angular/core';
import { Cartera } from 'src/app/modelo/cartera';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { ActivatedRoute, Router } from '@angular/router';

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
    }
  ];

 

  constructor(
    private carterasService: CarterasService,
    private ruta: ActivatedRoute,
    private router: Router
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

  borrarCartera(){
    if (confirm("¿Desea borrar esta cartera?")) {
      this.carterasService.borrarCartera(this.idCartera).subscribe(
        () => this.router.navigate(['/carteras'])
      )
    }
  }

  crearFondo(){
    this.carterasService.altaFondo(this.idCartera, {

      nombre: String,
      sector: String,
      tipo: String,
      riesgo: String,
      capitalInvertido: Number

    }).subscribe(
      respuesta => this.fondos.push(respuesta)
    )
  }





}
