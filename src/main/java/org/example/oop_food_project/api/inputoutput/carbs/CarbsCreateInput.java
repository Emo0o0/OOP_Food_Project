package org.example.oop_food_project.api.inputoutput.carbs;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarbsCreateInput implements OperationInput {

    private int vitaminAiu;
    private int vitaminB1mg;
    private int vitaminB12mg;
}
