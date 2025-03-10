package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverInput;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverListOutput;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverOperation;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodGetByCaloriesOverOperationProcessor implements FoodGetByCaloriesOverOperation {
    @Override
    public FoodGetByCaloriesOverListOutput process(FoodGetByCaloriesOverInput foodGetByCaloriesOverInput) {
        return null;
    }
}
