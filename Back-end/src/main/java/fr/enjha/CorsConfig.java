package fr.enjha;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Définissez le chemin approprié pour vos API
                        .allowedOrigins("http://localhost:4200") // Spécifiez les origines autorisées
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Spécifiez les méthodes HTTP autorisées
                        .allowedHeaders("*"); // Spécifiez les en-têtes autorisés
            }
        };
    }
}