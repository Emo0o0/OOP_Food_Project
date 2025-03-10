package org.example.oop_food_project.core.service.food;

import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateInput;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateOperation;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateOutput;
import org.springframework.stereotype.Service;

@Service
public class FoodCreateOperationProcessor implements FoodCreateOperation {
    @Override
    public FoodCreateOutput process(FoodCreateInput foodCreateInput) {
        return null;
    }
}
