import { Component, OnInit } from '@angular/core';
import { environment } from './../../../environments/environment';


@Component({
  selector: 'app-pie',
  templateUrl: './pie.component.html',
  styleUrls: ['./pie.component.css']
})
export class PieComponent implements OnInit {

  propiedadX: string;

  constructor() { }

  ngOnInit() {
    this.propiedadX = environment.miPropiedadX;
  }

}
