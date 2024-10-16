package com.bancolombia.aplicacionbancaria.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuditoriaInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditoriaInterceptor.class);

    @Override  /*Se ejecuta antes de que el controlador procese la solicitud */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Solictud entrante: " + request.getMethod());
        LOGGER.info("Antes de procesar la petición...");
        return true;
    }

    @Override /*Se ejecuta despues de que el controlador procese la solicitud, pero antes de que se envíe la respuesta */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("Después de procesar la petición...");
    }

    @Override /*Se ejecuta despues de que se envía la respuesta al cliente */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Solicitud completada para: " + request.getMethod() + " " + request.getRequestURI());
        LOGGER.info("Después de completar la petición...");
    }
}
