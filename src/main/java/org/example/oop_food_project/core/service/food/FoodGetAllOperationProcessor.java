package org.example.oop_food_project.core.service.food;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllInput;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllListOutput;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllOperation;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllOutput;
import org.example.oop_food_project.persistence.entity.Food;
import org.example.oop_food_project.persistence.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodGetAllOperationProcessor implements FoodGetAllOperation {

    private final FoodRepository foodRepository;

    @Override
    public FoodGetAllListOutput process(FoodGetAllInput foodGetAllInput) {

        List<Food> highVitaminAFoods = foodRepository.findAll();

        return FoodGetAllListOutput.builder()
                .food(highVitaminAFoods.stream()
                        .map(food -> FoodGetAllOutput.builder()
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
