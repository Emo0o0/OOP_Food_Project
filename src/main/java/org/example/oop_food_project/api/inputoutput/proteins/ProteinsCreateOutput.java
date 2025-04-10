package org.example.oop_food_project.api.inputoutput.proteins;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;
import org.example.oop_food_project.persistence.entity.Proteins;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProteinsCreateOutput implements OperationOutput {

    private int id;
    private Proteins proteins;
}
