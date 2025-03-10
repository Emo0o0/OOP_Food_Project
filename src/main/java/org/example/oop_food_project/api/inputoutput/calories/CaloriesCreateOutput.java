package org.example.oop_food_project.api.inputoutput.calories;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesCreateOutput implements OperationOutput {

    private int id;
}
