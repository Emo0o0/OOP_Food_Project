package org.example.oop_food_project.api.inputoutput.food.gethighvitamina;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighVitaminAListOutput implements OperationOutput {

    private List<FoodGetWithHighVitaminAOutput> food;
}
