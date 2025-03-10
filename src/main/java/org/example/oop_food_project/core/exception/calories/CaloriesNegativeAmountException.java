package org.example.oop_food_project.core.exception.calories;

public class CaloriesNegativeAmountException extends RuntimeException {
    public CaloriesNegativeAmountException(String message) {
        super(message);
    }
}
