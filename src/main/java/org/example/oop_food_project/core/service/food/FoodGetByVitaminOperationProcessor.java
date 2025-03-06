package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminInput;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminListOutput;
import org.example.oop_food_project.api.inputoutput.food.getbyvitamin.FoodGetByVitaminOperation;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetByVitaminOperationProcessor implements FoodGetByVitaminOperation {

    private final FoodRepository foodRepository;

//    public FoodGetByVitaminOperationProcessor(FoodRepository foodRepository) {
//        this.foodRepository = foodRepository;
//    }

    @Override
    public FoodGetByVitaminListOutput process(FoodGetByVitaminInput input) {
        return null;
    }
}
