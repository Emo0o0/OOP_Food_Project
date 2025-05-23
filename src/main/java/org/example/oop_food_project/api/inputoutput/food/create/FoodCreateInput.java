package org.example.oop_food_project.api.inputoutput.food.create;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodCreateInput implements OperationInput {

    private String product;
    private String productType;
    private int vitaminAiu;
    private int vitaminB1mg;
    private int vitaminB12mg;
    private int proteinAmount;
    private int monounsaturatedFatsGrams;
    private int polyunsaturatedFatsGrams;
    private int saturatedFatsGrams;
    private int transFatsGrams;
    private int calories;

}
