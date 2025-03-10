package org.example.oop_food_project.api.inputoutput.food.getbycaloriesover;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetByCaloriesOverInput implements OperationInput {

    private int calories;
}
