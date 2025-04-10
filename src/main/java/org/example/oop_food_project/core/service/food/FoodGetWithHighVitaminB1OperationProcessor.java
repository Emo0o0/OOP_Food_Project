package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1Input;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1ListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1Operation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1Output;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetWithHighVitaminB1OperationProcessor implements FoodGetWithHighVitaminB1Operation {

    private final FoodRepository foodRepository;

    @Override
    public FoodGetWithHighVitaminB1ListOutput process(FoodGetWithHighVitaminB1Input foodGetWithHighVitaminB1Input) {

        List<Food> highVitaminAFoods = foodRepository.findAllFoodWithHighVitaminB1();

        return FoodGetWithHighVitaminB1ListOutput.builder()
                .food(highVitaminAFoods.stream()
                        .map(food -> FoodGetWithHighVitaminB1Output.builder()
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
