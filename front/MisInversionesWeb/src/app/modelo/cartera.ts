import { Fondo } from './fondo';
import { Usuario } from './usuario';

export interface Cartera{
    nombre: String;
    fechaCreacionCartera: Date;
    capitalInvertido: number;
    rentabilidad: number;
}