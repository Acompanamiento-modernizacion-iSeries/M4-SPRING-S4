package co.com.coban.aplicacionbancaria.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Exception handler sirve para manejar excepciones de un tipo específico, en este caso IllegalArgumentException
    // combinado con el controlleradvice, se encarga de manejar las excepciones de tipo IllegalArgumentException
    // que se lancen en cualquier controlador de la aplicación
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarArgumentoInvalido(IllegalArgumentException ex) {
        return new ResponseEntity<>("Argumento inválido: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> manejarCuentaNoEncontrada(NullPointerException ex) {
        return new ResponseEntity<>("La cuenta no existe: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> manejarNumerosNegativos() {
        return new ResponseEntity<>("No se permiten números negativos", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException ex) {
        // se usa map para devolver objetos en formato clave-valor o tipo json
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> manejarErroresGenerales(Exception ex) {
//        return ResponseEntity.badRequest().body("Esta excepción no se esperaba: " + ex.getMessage());
//    }

}
