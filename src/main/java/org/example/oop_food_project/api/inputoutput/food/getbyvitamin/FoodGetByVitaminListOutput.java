package org.example.oop_food_project.api.inputoutput.food.getbyvitamin;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetByVitaminListOutput implements OperationOutput {

    List<FoodGetByVitaminOutput> foodGetByVitaminList;
}
