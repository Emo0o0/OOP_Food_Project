package org.example.oop_food_project.api.inputoutput.fats;

import lombok.*;
import org.example.oop_food_project.api.base.OperationOutput;
import org.example.oop_food_project.persistence.entity.Fats;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FatsCreateOutput implements OperationOutput {

    private int id;
    private Fats fats;
}
