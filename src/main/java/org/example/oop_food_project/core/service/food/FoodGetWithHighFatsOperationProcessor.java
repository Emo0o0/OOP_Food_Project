package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsInput;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsOutput;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetWithHighFatsOperationProcessor implements FoodGetWithHighFatsOperation {

    private final FoodRepository foodRepository;

    @Override
    public FoodGetWithHighFatsListOutput process(FoodGetWithHighFatsInput foodGetWithHighFatsInput) {

        List<Food> highFatsFood = foodRepository.findAllFoodWithHighFats();

        return FoodGetWithHighFatsListOutput.builder()
                .food(highFatsFood.stream()
                        .map(food -> FoodGetWithHighFatsOutput.builder()
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
