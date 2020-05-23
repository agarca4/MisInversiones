# INSTRUCCIONES

- La APP está desplegada y operativa en esa [URL](https://agarca4.github.io)  
- Puede consultar la documentación accediendo a la [WIKI](https://git.institutomilitar.com/agarca4/mis-inversiones-/wikis/home)
- Para documentacion más especifica del FRONT, descarge este [directorio](https://git.institutomilitar.com/agarca4/mis-inversiones-/tree/master/front/MisInversionesWeb/documentation) y haga click en el index.html

### PARA DESARROLLADORES
- Clone el repositorio
- Acceda al direccorio front/MisInversionesWeb
- Ejecute en una terminal: 
    
        npm install modules

        ng serve

- La app de desplegará en servidor local y entorno de desarrollo

*Nota: Para desplegar la api se ha recurrido a HEROKU y PostgreSQL como BBDD*


# MIS INVERSIONES: funcionalidades

- Se necesita una aplicación para poder llevar el control doméstico de la inversiones financieras de distintos productos tipo fondos de inversión, depósitos etc.  

- EL usuario podrá acceder a su cartera de inversiones con distintos productos que tendrán su precio de adquisición y su peso específico en su cartera. El usuario podrá ver el estado actual de sus inversiones (beneficios o perdidas) mostrando gráficos o diagramas con la trayectoria que esté llevando.  

- El usuario también  podrá comparar la rentabilidad financiera de la cartera con distintos índices bursátiles de referencia, de forma que podamos calificar de alguna forma (estrellas, numéricamente...) la cartera del cliente.  

 - La aplicación debe permitir al usuario modificar los datos de tal forma que podrá ir haciendo nuevos desembolsos o reembolsos para realizar los beneficios o si la rentabilidad del producto en cuestión está en caída libre.  

 - Se podrá también analizar la cartera a fondo, permitiendo que el usuario pueda consultar su rentabilidad financiera, acumulada, comisiones de gestión que paga, riesgo que asume, volatilidad, ratio de Sharpe...  
  
- Aunque previsiblemente, esta aplicación no tendrá acceso desde dispositivos móviles, su diseño debe ser responsive.
