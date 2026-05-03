package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot application entry point for War Game Simulation.
 *
 * This serves as the main entry point for the Spring Boot version of the application.
 * It starts the embedded Tomcat server and initializes the Spring context.
 *
 * @author Felipe Mardones
 * @version 2.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"app", "algo", "model"})
public class WarGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarGameApplication.class, args);
    }
}

