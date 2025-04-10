package org.example.oop_food_project.api.inputoutput.food.gethighfats;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighFatsListOutput implements OperationOutput {

    private List<FoodGetWithHighFatsOutput> food;
}
