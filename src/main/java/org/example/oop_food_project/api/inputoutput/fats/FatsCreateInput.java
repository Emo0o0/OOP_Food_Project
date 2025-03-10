package org.example.oop_food_project.api.inputoutput.fats;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FatsCreateInput implements OperationInput {

    private int monounsaturatedFatsGrams;
    private int polyunsaturatedFatsGrams;
    private int saturatedFatsGrams;
    private int transFatsGrams;
}
