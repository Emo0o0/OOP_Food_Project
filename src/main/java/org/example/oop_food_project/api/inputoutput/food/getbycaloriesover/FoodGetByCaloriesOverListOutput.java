package org.example.oop_food_project.api.inputoutput.food.getbycaloriesover;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetByCaloriesOverListOutput implements OperationOutput {

    private List<FoodGetByCaloriesOverOutput> food;
}
