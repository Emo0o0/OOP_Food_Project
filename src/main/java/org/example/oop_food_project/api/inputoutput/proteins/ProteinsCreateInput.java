package org.example.oop_food_project.api.inputoutput.proteins;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProteinsCreateInput implements OperationInput {

    private String description;
}
