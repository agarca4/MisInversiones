import { Injectable } from '@angular/core';
import { FondosService } from './fondos.service';
import { Observable } from 'rxjs';
import { Fondo } from '../modelo/fondo';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


const url_base = 'http://localhost:8081/api/fondos';

@Injectable({
  providedIn: 'root'
})
export class FondosApiService extends FondosService {


  constructor(private http: HttpClient) {
    super()
  }

  getFondos(): Observable<Fondo[]> {
    return this.http.get(url_base).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].fondos : [])

    );
  }


}
