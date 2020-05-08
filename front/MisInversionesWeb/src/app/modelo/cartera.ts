import { Fondo } from './fondo';
import { Usuario } from './usuario';

export interface Cartera{
    nombreCartera: String;
    fechaCreacionCartera: Date;
    capitalInvertido: number;
    rentabilidad: number;
    usuarios: Usuario[];
    fondos: Fondo[];
}