# M4-SPRING-S2
# Taller: API para Manejo de Cuenta 2
> **Larry M. Ramírez - Coach Técnico**

## Objetivo.
 Los participantes deben implementar una API bancaria que maneje operaciones con inyección de dependencias y manejo de excepciones.

## Instrucciones
- Crear un Servicio `CuentaService` que se encargue de la lógica de negocio:
	- Manejar las operaciones de consulta de saldo, depósito y retiro.
	- Asegurar que el saldo no sea negativo y que no se puedan realizar depósitos con montos inválidos.
- Modificar el Controlador `CuentaController`:
	- Inyectar el servicio `CuentaService` usando constructor o inyección de campo.
	- Crear los endpoints para consultar el saldo, hacer depósitos y retiros.
- Gestionar las excepciones con `@ExceptionHandler` para manejar depósitos con montos inválidos y retiros con saldo insuficiente.
- Realizar pruebas de depósito y retiro, asegurándose de que las excepciones se manejen correctamente.
- Verificar que el saldo se actualice después de cada operación exitosa.

**Nota:** Los talleres deben entregarse por medio de la estrategia establecida para la formación, por medio de un Pull Request desde el repositorio Fork hacia la rama main del repositorio del taller. 
