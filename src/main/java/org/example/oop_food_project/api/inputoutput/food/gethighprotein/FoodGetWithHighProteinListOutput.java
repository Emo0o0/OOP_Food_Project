package org.example.oop_food_project.api.inputoutput.food.gethighprotein;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighProteinListOutput implements OperationOutput {

    private List<FoodGetWithHighProteinOutput> food;
}
