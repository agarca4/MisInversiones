import { Cartera } from '../modelo/cartera';

export abstract class CarterasService {

    abstract getCarteras(): Cartera[];

    abstract getCarterasConNombre(filtro): Cartera[];

    abstract crearCartera(cartera: Cartera);

    abstract getCarteraPorId(id): Cartera;

    abstract modificarCartera(id: string, cartera: Cartera);
}