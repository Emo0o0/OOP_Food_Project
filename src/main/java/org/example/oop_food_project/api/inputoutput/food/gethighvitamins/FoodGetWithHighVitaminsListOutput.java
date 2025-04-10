package org.example.oop_food_project.api.inputoutput.food.gethighvitamins;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodGetWithHighVitaminsListOutput implements OperationOutput {

    List<FoodGetWithHighVitaminsOutput> food;
}
