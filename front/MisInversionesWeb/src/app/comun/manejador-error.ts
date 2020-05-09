import { ErrorHandler } from '@angular/core';

export class ManejadorError implements ErrorHandler {

    handleError(error: any): void {
        alert('Mensaje desde el manejador global: Error ' + error.message);

    }

}