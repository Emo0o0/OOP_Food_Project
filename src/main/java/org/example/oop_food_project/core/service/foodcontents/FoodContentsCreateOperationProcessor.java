package org.example.oop_food_project.core.service.foodcontents;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.foodcontents.FoodContentsCreateInput;
import org.example.oop_food_project.api.inputoutput.foodcontents.FoodContentsCreateOperation;
import org.example.oop_food_project.api.inputoutput.foodcontents.FoodContentsCreateOutput;
import org.example.oop_food_project.persistence.entity.FoodContents;
import org.example.oop_food_project.persistence.repository.FoodContentsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodContentsCreateOperationProcessor implements FoodContentsCreateOperation {

    private final FoodContentsRepository foodContentsRepository;

    @Override
    public FoodContentsCreateOutput process(FoodContentsCreateInput input) {

        FoodContents foodContents = FoodContents.builder()
                .carbs(input.getCarbs())
                .fats(input.getFats())
                .proteins(input.getProteins())
                .calories(input.getCalories())
                .build();

        foodContentsRepository.save(foodContents);

        return FoodContentsCreateOutput.builder()
                .id(foodContents.getFoodContentsId())
                .foodContents(foodContents)
                .build();
    }
}
