import { Cartera } from '../modelo/cartera';
import { Observable } from 'rxjs';

export abstract class CarterasService {

    abstract getCarteras(): Observable<Cartera[]>;

    abstract getCarterasConNombre(filtro): Cartera[];

    abstract crearCartera(cartera: Cartera);

    abstract getCarteraPorId(id): Cartera;

    abstract modificarCartera(id: string, cartera: Cartera);
}