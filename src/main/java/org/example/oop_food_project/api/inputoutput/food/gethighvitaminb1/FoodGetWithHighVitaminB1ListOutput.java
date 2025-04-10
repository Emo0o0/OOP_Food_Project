package org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighVitaminB1ListOutput implements OperationOutput {

    private List<FoodGetWithHighVitaminB1Output> food;

}
