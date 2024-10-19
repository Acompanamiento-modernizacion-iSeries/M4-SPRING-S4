# M4-SPRING-S3
# Taller: API para Manejo de Cuenta 3
> **Larry M. Ramírez - Coach Técnico**

## Objetivo.
Implementar un sistema de auditoría que registre todas las solicitudes HTTP y las operaciones realizadas sobre una cuenta bancaria. Además, validar los datos recibidos en las solicitudes.

## Instrucciones
- Modificar el Controlador `CuentaController` :
	- Asegurarse de que todas las operaciones bancarias (consulta de saldo, depósito y retiro) estén bien definidas.
	- Usar anotaciones de validación como `@NotNull`, `@Min`, etc., para validar los datos de entrada (monto de depósito/retiro).
- Crear el Interceptor `AuditoriaInterceptor`:
	- Implementar un interceptor que registre las solicitudes HTTP entrantes y las operaciones completadas.
	- Asegurarse de que se registren tanto las solicitudes válidas como los errores.
- Registrar el interceptor en el contexto de Spring para que se aplique a todas las solicitudes relacionadas con la cuenta bancaria.
- Realizar pruebas de depósito y retiro, asegurándose de que las excepciones se manejen correctamente.
- Verificar que el saldo se actualice después de cada operación exitosa.
- Verificar en los logs del servidor que todas las solicitudes y transacciones queden registradas.

**Nota:** Los talleres deben entregarse por medio de la estrategia establecida para la formación, por medio de un Pull Request desde el repositorio Fork hacia la rama main del repositorio del taller. 
