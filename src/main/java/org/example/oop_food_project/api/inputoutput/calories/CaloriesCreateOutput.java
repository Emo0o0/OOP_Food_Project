package org.example.oop_food_project.api.inputoutput.calories;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;
import org.example.oop_food_project.persistence.entity.Calories;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesCreateOutput implements OperationOutput {

    private int id;
    private Calories calories;
}
