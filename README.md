# M4-SPRING-S1

# Taller: API para Manejo de Cuenta
> **Larry M. Ramírez - Coach Técnico**

## Objetivo.
Desarrollar un pequeño sistema de gestión de cuentas bancarias con Spring Boot, implementando operaciones básicas.

## Instrucciones
- Crear un controlador llamado `CuentaController` con los siguientes endpoints:
     -   **GET /cuenta/saldo**: Devuelve el saldo de la cuenta.
    -   **POST /cuenta/deposito**: Recibe un valor como parámetro y lo suma al saldo.
    -   **POST /cuenta/retiro**: Recibe un valor y lo resta del saldo, siempre y cuando el saldo sea suficiente.
- Recibir el numero de cuenta a manejar como parámetro.
- Implementar lógica de negocio básica para manejar un set de cuentas bancarias.
- Definir una base de datos en memoria para precargar las cuentas.
 -   Asegurarse de que el saldo nunca sea negativo.  
 -   Probar todos los endpoints para asegurarse de que funcionan correctamente.
 -   Verificar la actualización del saldo con las operaciones de depósito y retiro.

**Nota:** Los talleres deben entregarse por medio de la estrategia establecida para la formación, por medio de un Pull Request desde el repositorio Fork hacia la rama main del repositorio del taller. 
