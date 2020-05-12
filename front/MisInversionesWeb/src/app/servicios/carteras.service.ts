import { Cartera } from '../modelo/cartera';
import { Observable } from 'rxjs';

export abstract class CarterasService {

    abstract getCarteras(): Observable<Cartera[]>;

    abstract getCarterasConNombre(filtro): Observable <Cartera[]>;

    abstract crearCartera(cartera: Cartera);

    abstract getCarteraPorId(id: string): Observable <Cartera>;

    abstract modificarCartera(id: string, cartera: Cartera);

    abstract getFondosPorCartera(id: String);

   abstract  getIdCartera(cartera);
}