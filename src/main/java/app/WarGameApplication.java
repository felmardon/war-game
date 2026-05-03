package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(WarGameApplication.class);

    public static void main(String[] args) {
        logger.info("Starting War Game Simulation application...");
        logger.debug("Application arguments: {}", (Object) args);
        SpringApplication.run(WarGameApplication.class, args);
        logger.info("War Game Simulation application started successfully");
    }
}

