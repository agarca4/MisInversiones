import { Component, OnInit } from '@angular/core';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Cartera } from 'src/app/modelo/cartera';


@Component({
  selector: 'app-carteras-form',
  templateUrl: './carteras-form.component.html',
  styleUrls: ['./carteras-form.component.css']
})
export class CarterasFormComponent implements OnInit {


  cartera: Cartera;
  titulo: string;


  constructor(
    private carterasService: CarterasService,
    private router: Router,
    private ruta: ActivatedRoute

  ) { }

  ngOnInit() {
    let id = this.ruta.snapshot.paramMap.get('id');
    if (id) {
      this.cartera = this.carterasService.getCarteraPorId(id);
      this.titulo = 'Editar nombre de la Cartera';
    } else {

      this.cartera = {
        nombreCartera: null,
        fechaCreacionCartera: null,
        capitalInvertido: 0.0,
        rentabilidad: 0.0

      }
      this.titulo = 'Alta nueva Cartera';

    }



  }
  guardar(f: NgForm) {
    let id = this.ruta.snapshot.paramMap.get('id');
    if (id) {
      this.carterasService.modificarCartera(id,this.cartera);
    } else {
      this.carterasService.crearCartera(this.cartera);

    }



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
