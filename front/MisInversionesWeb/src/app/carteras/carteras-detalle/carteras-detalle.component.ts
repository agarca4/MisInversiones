import { Component, OnInit } from '@angular/core';
import { Cartera } from 'src/app/modelo/cartera';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { ActivatedRoute, Router } from '@angular/router';
import { fondos_data_nombres } from './../../Data/fondos.data';


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

  fondo = {
    nombre: null,
    sector: null,
    tipo: null,
    riesgo: null,
    precioParticipacion: 0.0,
    capitalInvertido: 0.0
  }

  fondos = [];
  nombres=fondos_data_nombres;
  tipos = ["RENTA FIJA", "RENTA VARIABLE", "MIXTO"];
  sectores = ["TECNOLOGIA", "CONSUMO DEFENSIVO", "INDUSTRIA", "CONSUMO CICLICO", "SALUD", "SERVICIOS FINANCIEROS"];




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


  borrarCartera() {
    if (confirm("¿Desea borrar esta cartera?")) {
      this.carterasService.borrarCartera(this.idCartera).subscribe(
        () => this.router.navigate(['/carteras'])
      )
    }
  }

  crearFondo() {
    this.carterasService.crearFondoEnCartera(this.idCartera, this.fondo).subscribe(
      respuesta => this.fondos.push(respuesta)
    )
  }
  borrarFondo(fondo) {
    if (confirm("¿Desea dar de baja este fondo de su cartera?")) {
      this.carterasService.borrarFondoEnCartera(this.idCartera, fondo).subscribe(
        () => this.fondos.splice(this.fondos.indexOf(fondo), 1))
    }

  }




}
