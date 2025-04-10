package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAInput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAOutput;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetWithHighVitaminAOperationProcessor implements FoodGetWithHighVitaminAOperation {

    private final FoodRepository foodRepository;

    @Override
    public FoodGetWithHighVitaminAListOutput process(FoodGetWithHighVitaminAInput foodGetWithHighVitaminAInput) {

        List<Food> highVitaminAFoods = foodRepository.findAllFoodWithHighVitaminA();

        return FoodGetWithHighVitaminAListOutput.builder()
                .food(highVitaminAFoods.stream()
                        .map(food -> FoodGetWithHighVitaminAOutput.builder()
                                .product(food.getProduct())
                                .productType(food.getProductType())
                                .calories(food.getFoodContentsPer100().getCalories().getCalories())
                                .vitaminAiu(food.getFoodContentsPer100().getCarbs().getVitaminAiu())
                                .vitaminB1mg(food.getFoodContentsPer100().getCarbs().getVitaminB1mg())
                                .vitaminB12mg(food.getFoodContentsPer100().getCarbs().getVitaminB12mg())
                                .monounsaturatedFatsGrams(food.getFoodContentsPer100().getFats().getMonounsaturatedFatsGrams())
                                .polyunsaturatedFatsGrams(food.getFoodContentsPer100().getFats().getPolyunsaturatedFatsGrams())
                                .saturatedFatsGrams(food.getFoodContentsPer100().getFats().getSaturatedFatsGrams())
                                .transFatsGrams(food.getFoodContentsPer100().getFats().getTransFatsGrams())
                                .proteinsAmount(food.getFoodContentsPer100().getProteins().getAmount())
                                .build())
                        .toList())
                .build();

    }
}
