package org.example.oop_food_project.api.inputoutput.carbs;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarbsCreateOutput implements OperationOutput {

    private int id;
}
