package co.com.coban.aplicacionbancaria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// configuracion hace referencia a que esta clase puede crear beans de Spring
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // webconfigurer es una interfaz que permite configurar aspectos de la aplicación web
    // en este caso se usa para agregar un interceptor a la aplicación web
    // un interceptor es un componente que permite interceptar las peticiones HTTP

    @Autowired
    private AuditoriaInterceptor auditoriaInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // permite agregar un interceptor a la aplicación web sobreescribiendo el método addInterceptors
        registry.addInterceptor(auditoriaInterceptor);
    }
}
