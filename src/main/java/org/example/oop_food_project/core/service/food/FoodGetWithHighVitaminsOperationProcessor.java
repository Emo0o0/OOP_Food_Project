package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsInput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsOutput;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetWithHighVitaminsOperationProcessor implements FoodGetWithHighVitaminsOperation {

    private final FoodRepository foodRepository;

    @Override
    public FoodGetWithHighVitaminsListOutput process(FoodGetWithHighVitaminsInput foodGetWithHighVitaminsInput) {

        List<Food> highVitaminFoods = foodRepository.findAllFoodWithHighVitamins();

        return FoodGetWithHighVitaminsListOutput.builder()
                .food(highVitaminFoods.stream()
                        .map(food -> FoodGetWithHighVitaminsOutput.builder()
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
