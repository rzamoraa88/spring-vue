package demofacturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemofacturasApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemofacturasApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/facturas/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
                //registry.addMapping("/facturas-javaconfig").allowedOrigins("http://localhost:8081");
            }
        };
    }
}
