package co.com.coban.aplicacionbancaria.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component // es un componente generico de Spring y se debe registrar en el contenedor de Spring
public class AuditoriaInterceptor implements HandlerInterceptor {
    // los interceptores son una forma de agregar funcionalidades a los métodos de un bean de Spring
    // se ejecutan antes y después de la ejecución de un método
    // se pueden usar para agregar funcionalidades como logs, auditorias, etc.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("Solicitud (entrante) antes de ejecutar el método del controlador: " + request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    throws Exception {
        System.out.println(
                "Solicitud (saliente) despues de ejecutar el método del controlador: "
                + request.getMethod() + " " + request.getRequestURI() + " " + response.getStatus());

    }
}
