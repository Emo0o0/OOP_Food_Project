package org.example.oop_food_project.api.inputoutput.food.getall;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetAllListOutput implements OperationOutput {

    private List<FoodGetAllOutput> food;
}
