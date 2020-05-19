import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FavoritoEvent } from './favorito-event';


@Component({
  selector: 'favorito',
  templateUrl: './favorito.component.html',
  styleUrls: ['./favorito.component.css']
})
export class FavoritoComponent implements OnInit {

  @Input() coleccion: string = "favoritos";
  @Input() valor: string;
  @Input() color: string = "green";
  @Input() escala: number = 1;

  @Output() cambia = new EventEmitter();

  esFavorito: boolean = false;

  constructor() { }

  ngOnInit() {
    let coleccion_array;
    if (localStorage.getItem(this.coleccion) != null) {
      coleccion_array = JSON.parse(localStorage.getItem(this.coleccion));

    } else {
      localStorage.setItem(this.coleccion, JSON.stringify(new Array()));
    }


    this.esFavorito = (coleccion_array.indexOf(this.valor) >= 0);


  }

  cambiaFavorito() {
    let coleccion_array = JSON.parse(localStorage.getItem(this.coleccion));
    if (this.esFavorito) {
      coleccion_array.splice(coleccion_array.indexOf(this.valor), 1);
    } else {
      coleccion_array.push(this.valor);
    }
    localStorage.setItem(this.coleccion, JSON.stringify(coleccion_array));

    this.esFavorito = !this.esFavorito;

    let evento: FavoritoEvent = {
      coleccion: this.coleccion,
      valor: this.valor,
      esFavorito: this.esFavorito
    }

    this.cambia.emit(evento);
  }

}
