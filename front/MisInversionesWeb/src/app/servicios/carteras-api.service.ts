import { Injectable } from '@angular/core';
import { CarterasService } from './carteras.service';
import { Cartera } from '../modelo/cartera';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators'


const url_base = 'http://localhost:8081/api/carteras';

@Injectable({
  providedIn: 'root'
})
export class CarterasApiService extends CarterasService {


  constructor(private http: HttpClient) {
    super();
  }

  getCarteras(): Observable<Cartera[]> {
    return this.http.get(url_base).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].carteras : [])

    );

  }

  getCarterasConNombre(filtro: any): Observable<Cartera[]> {

    return this.http.get(`${url_base}/search/nombre/?nombre=${filtro}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].carteras : [])
    )

  }
  crearCartera(cartera: Cartera) {
    return this.http.post(url_base, cartera);

  }
  getCarteraPorId(id: string): Observable<Cartera> {

    return this.http.get(`${url_base}/${id}`).pipe(
      map(respuesta => respuesta as Cartera)
    )

  }

  modificarCartera(id: string, cartera: Cartera) {

    return this.http.patch(`${url_base}/${id}`, cartera).pipe(
      catchError(
        (error: HttpErrorResponse) => {
          if (error.status === 404) {
            alert('Mensaje desde el Observable: Cartera no encontrada')
          }
          else {
            alert('Mensaje desde el Observable: Error inesperado: ' + error.message)
          }
          return [];
        }
      )
    )

  }
}
