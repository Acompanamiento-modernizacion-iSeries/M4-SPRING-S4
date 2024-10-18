package com.taller4.william.bancolombia.app.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class AuditoriaInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuditoriaInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Solicitud entrante: {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            logger.error("Error en la solicitud: {}", ex.getMessage(), ex);
        } else if (response.getStatus() >= 400) {
            logger.error("Error HTTP {} en la solicitud: {} {}", response.getStatus(), request.getMethod(), request.getRequestURI());
        } else {
            logger.info("Solicitud completada correctamente: {} {}", request.getMethod(), request.getRequestURI());
        }
    }
}