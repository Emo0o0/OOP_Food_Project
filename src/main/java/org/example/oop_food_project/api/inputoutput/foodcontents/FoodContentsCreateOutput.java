package org.example.oop_food_project.api.inputoutput.foodcontents;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;
import org.example.oop_food_project.persistence.entity.FoodContents;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodContentsCreateOutput implements OperationOutput {

    private int id;
    private FoodContents foodContents;
}
