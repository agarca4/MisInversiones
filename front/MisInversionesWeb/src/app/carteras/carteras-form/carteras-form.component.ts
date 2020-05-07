import { Component, OnInit } from '@angular/core';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-carteras-form',
  templateUrl: './carteras-form.component.html',
  styleUrls: ['./carteras-form.component.css']
})
export class CarterasFormComponent implements OnInit {


  cartera;
 

  constructor(private carterasService: CarterasService, private router: Router) { }

  ngOnInit() {
    this.cartera = {
      nombreCartera: null,
      fechaCreacionCartera: null,
      capitalInvertido: 0.0,
      rentabilidad: null

    }
  }
  guardar(f: NgForm) {
    this.carterasService.crearCartera(this.cartera);
    this.router.navigate(['/carteras']);
  }
  cancelar(f: NgForm) {
    if (f.dirty) {
      if (confirm('Las modificaciones se perderan. ¿Está seguro?') == false) {
        return;
      }
    }
    this.router.navigate(['/carteras']);
  }

}
