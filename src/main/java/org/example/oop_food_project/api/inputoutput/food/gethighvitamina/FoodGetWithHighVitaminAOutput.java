package org.example.oop_food_project.api.inputoutput.food.gethighvitamina;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighVitaminAOutput {

    private String product;
    private String productType;
    private int calories;
    private int vitaminAiu;
    private int vitaminB1mg;
    private int vitaminB12mg;
    private int monounsaturatedFatsGrams;
    private int polyunsaturatedFatsGrams;
    private int saturatedFatsGrams;
    private int transFatsGrams;
    private int proteinsAmount;
}
