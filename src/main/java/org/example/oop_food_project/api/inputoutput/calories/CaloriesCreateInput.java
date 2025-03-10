package org.example.oop_food_project.api.inputoutput.calories;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesCreateInput implements OperationInput {

    private int calories;

}
