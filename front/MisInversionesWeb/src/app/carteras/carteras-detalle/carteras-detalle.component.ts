import { Component, OnInit } from '@angular/core';
import { Cartera } from 'src/app/modelo/cartera';

@Component({
  selector: 'app-carteras-detalle',
  templateUrl: './carteras-detalle.component.html',
  styleUrls: ['./carteras-detalle.component.css']
})
export class CarterasDetalleComponent implements OnInit {

  idCartera = "1";
  cartera: Cartera;

  constructor() { }

  ngOnInit(): void {
  }

}
