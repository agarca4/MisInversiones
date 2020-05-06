import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carteras-form',
  templateUrl: './carteras-form.component.html',
  styleUrls: ['./carteras-form.component.css']
})
export class CarterasFormComponent implements OnInit {


  cartera;

  constructor() { }

  ngOnInit() {
    this.cartera = {
      nombreCartera: null,
      fechaCreacionCartera: null,
      capitalInvertido: 0.0,
      rentabilidad: null

    }
  }

}
