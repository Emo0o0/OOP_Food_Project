package org.example.oop_food_project.api.inputoutput.foodcontents;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodContentsCreateOperationProcessor implements FoodContentsCreateOperation {

    @Override
    public FoodContentsCreateOutput process(FoodContentsCreateInput foodContentsCreateInput) {
        return null;
    }
}
