import { Cartera } from '../modelo/cartera';
import { Observable } from 'rxjs';

export abstract class CarterasService {

    abstract getCarteras(): Observable<Cartera[]>;

    abstract getCarterasConNombre(filtro): Observable<Cartera[]>;

    abstract crearCartera(cartera: Cartera);

    abstract getCarteraPorId(id: string): Observable<Cartera>;

    abstract modificarCartera(id: string, cartera: Cartera);

    abstract getFondosPorCartera(id: String);

    abstract getIdCartera(cartera);

    abstract borrarCartera(id: String): Observable<Object>;

    abstract crearFondoEnCartera(idCartera, fondo): Observable<Object>;

    abstract borrarFondoEnCartera(idPartido, fondo): Observable<Object>;
}