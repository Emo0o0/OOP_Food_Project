package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.calories.CaloriesCreateInput;
import org.example.oop_food_project.api.inputoutput.calories.CaloriesCreateOperation;
import org.example.oop_food_project.api.inputoutput.carbs.CarbsCreateInput;
import org.example.oop_food_project.api.inputoutput.carbs.CarbsCreateOperation;
import org.example.oop_food_project.api.inputoutput.fats.FatsCreateInput;
import org.example.oop_food_project.api.inputoutput.fats.FatsCreateOperation;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateInput;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateOperation;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateOutput;
import org.example.oop_food_project.api.inputoutput.foodcontents.FoodContentsCreateInput;
import org.example.oop_food_project.api.inputoutput.foodcontents.FoodContentsCreateOperation;
import org.example.oop_food_project.api.inputoutput.proteins.ProteinsCreateInput;
import org.example.oop_food_project.api.inputoutput.proteins.ProteinsCreateOperation;
import org.example.oop_food_project.persistence.entity.*;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodCreateOperationProcessor implements FoodCreateOperation {

    private final CaloriesCreateOperation caloriesCreateOperation;
    private final CarbsCreateOperation carbsCreateOperation;
    private final FatsCreateOperation fatsCreateOperation;
    private final ProteinsCreateOperation proteinsCreateOperation;
    private final FoodContentsCreateOperation foodContentsCreateOperation;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public FoodCreateOutput process(FoodCreateInput input) {

        Calories calories = caloriesCreateOperation.process(CaloriesCreateInput.builder()
                .calories(input.getCalories())
                .build()).getCalories();

        Carbs carbs = carbsCreateOperation.process(CarbsCreateInput.builder()
                .vitaminAiu(input.getVitaminAiu())
                .vitaminB1mg(input.getVitaminB1mg())
                .vitaminB12mg(input.getVitaminB12mg())
                .build()).getCarbs();

        Fats fats = fatsCreateOperation.process(FatsCreateInput.builder()
                .monounsaturatedFatsGrams(input.getMonounsaturatedFatsGrams())
                .saturatedFatsGrams(input.getSaturatedFatsGrams())
                .polyunsaturatedFatsGrams(input.getPolyunsaturatedFatsGrams())
                .transFatsGrams(input.getTransFatsGrams())
                .build()).getFats();

        Proteins proteins = proteinsCreateOperation.process(ProteinsCreateInput.builder()
                .amount(input.getProteinAmount())
                .build()).getProteins();

        FoodContents foodContents = foodContentsCreateOperation.process(FoodContentsCreateInput.builder()
                .calories(calories)
                .carbs(carbs)
                .fats(fats)
                .proteins(proteins)
                .build()).getFoodContents();

        Food food = Food.builder()
                .product(input.getProduct())
                .productType(input.getProductType())
                .foodContentsPer100(foodContents)
                .build();

        foodRepository.save(food);

        return FoodCreateOutput.builder()
                .id(food.getFoodId())
                .build();
    }
}
