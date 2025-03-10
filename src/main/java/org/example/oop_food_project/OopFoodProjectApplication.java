package org.example.oop_food_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.example.oop_food_project.persistence.entity")
@EnableJpaRepositories(basePackages = "org.example.oop_food_project.persistence.repository")
public class OopFoodProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OopFoodProjectApplication.class, args);
    }
}
