package org.example.oop_food_project.core.service.calories;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.calories.CaloriesCreateInput;
import org.example.oop_food_project.api.inputoutput.calories.CaloriesCreateOperation;
import org.example.oop_food_project.api.inputoutput.calories.CaloriesCreateOutput;
import org.example.oop_food_project.core.exception.calories.CaloriesNegativeAmountException;
import org.example.oop_food_project.persistence.entity.Calories;
import org.example.oop_food_project.persistence.repository.CaloriesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaloriesCreateOperationProcessor implements CaloriesCreateOperation {

    private final CaloriesRepository caloriesRepository;

    @Override
    public CaloriesCreateOutput process(CaloriesCreateInput input) {

        if (input.getCalories() < 0)
            throw new CaloriesNegativeAmountException("Calories cannot be negative");

        Calories calories = Calories.builder()
                .calories(input.getCalories())
                .build();

        caloriesRepository.save(calories);

        return CaloriesCreateOutput.builder()
                .id(calories.getCaloriesId())
                .calories(calories)
                .build();
    }
}
