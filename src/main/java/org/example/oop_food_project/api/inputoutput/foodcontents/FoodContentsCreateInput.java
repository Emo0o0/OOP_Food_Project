package org.example.oop_food_project.api.inputoutput.foodcontents;

import lombok.*;
import org.example.oop_food_project.api.base.OperationInput;
import org.example.oop_food_project.persistence.entity.Calories;
import org.example.oop_food_project.persistence.entity.Carbs;
import org.example.oop_food_project.persistence.entity.Fats;
import org.example.oop_food_project.persistence.entity.Proteins;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodContentsCreateInput implements OperationInput {

    private Carbs carbs;
    private Proteins proteins;
    private Fats fats;
    private Calories calories;
}
