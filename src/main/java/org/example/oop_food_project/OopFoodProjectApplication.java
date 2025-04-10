package org.example.oop_food_project;

import org.example.oop_food_project.controller.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;

@SpringBootApplication
@EntityScan(basePackages = "org.example.oop_food_project.persistence.entity")
@EnableJpaRepositories(basePackages = "org.example.oop_food_project.persistence.repository")
public class OopFoodProjectApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OopFoodProjectApplication.class);
        app.setHeadless(false); // Disable headless mode
        ApplicationContext context = app.run(args);

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = context.getBean(MainFrame.class);
            mainFrame.setVisible(true);
        });
    }

}
