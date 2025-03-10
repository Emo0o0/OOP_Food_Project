package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminInput;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminListOutput;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminOperation;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodGetByVitaminOperationProcessor implements FoodGetByVitaminOperation {

    @Override
    public FoodGetByVitaminListOutput process(FoodGetByVitaminInput input) {
        return null;
    }
}
