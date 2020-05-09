import { Observable } from 'rxjs';
import { Fondo } from '../modelo/fondo';

export abstract class FondosService{

    abstract getFondos(): Observable<Fondo[]>

}