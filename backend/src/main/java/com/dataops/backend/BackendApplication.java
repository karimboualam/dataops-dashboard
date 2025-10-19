package com.dataops.backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        // Charger les variables du fichier .env
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()  // Ne plante pas si le .env n'existe pas (utile pour Render)
                .load();

        // Injecter toutes les variables .env dans le système
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );

        // Démarrage normal de Spring Boot
        SpringApplication.run(BackendApplication.class, args);
    }
}
