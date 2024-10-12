package co.bancolombia.aplicacionbancaria.controller.helper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request ->" + request.getMethod() + " " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("Response -> " + request.getMethod() + " " + request.getRequestURI());
        if(request.getRequestURI().contains("error"))
            System.out.println("Operacion no exitosa");
        else
            System.out.println("Operacion exitosa");
        System.out.println("------------------------------");
    }



}
