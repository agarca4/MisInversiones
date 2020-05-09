import { Component, OnInit } from '@angular/core';
import { CarterasService } from 'src/app/servicios/carteras.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Cartera } from 'src/app/modelo/cartera';
import { HttpErrorResponse } from '@angular/common/http';


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
    this.cartera = {
      nombre: null,
      fechaCreacionCartera: new Date,
      capitalInvertido: null,
      rentabilidad: null
      
    }


    let id = this.ruta.snapshot.paramMap.get('id');
    if (id) {

      this.carterasService.getCarteraPorId(id).subscribe(
        (respuesta: any) => {
          this.cartera = respuesta;

        }
      )

      this.titulo = 'Editar nombre de la Cartera';
    } else {

      this.titulo = 'Alta nueva Cartera';
    }



  }
  guardar(f: NgForm) {
    let id = this.ruta.snapshot.paramMap.get('id');
    if (id) {
      this.carterasService.modificarCartera(id, this.cartera).subscribe(
        () => this.router.navigate(['/carteras'])
      )
    } else {
      this.carterasService.crearCartera(this.cartera).subscribe(
        () => this.router.navigate(['/carteras'])
      ),
        (error: HttpErrorResponse) => {
          alert('Mensaje desde el suscriptor: Se ha producido un error inesperado al crear la cartera: \n\n' + error.message)
        }

    }


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
