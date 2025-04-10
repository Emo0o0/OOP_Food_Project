package org.example.oop_food_project.core.service.carbs;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.carbs.CarbsCreateInput;
import org.example.oop_food_project.api.inputoutput.carbs.CarbsCreateOperation;
import org.example.oop_food_project.api.inputoutput.carbs.CarbsCreateOutput;
import org.example.oop_food_project.core.exception.carbs.CarbsNegativeValuesException;
import org.example.oop_food_project.persistence.entity.Carbs;
import org.example.oop_food_project.persistence.repository.CarbsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarbsCreateOperationProcessor implements CarbsCreateOperation {

    private final CarbsRepository carbsRepository;

    @Override
    public CarbsCreateOutput process(CarbsCreateInput input) {

        if (input.getVitaminAiu() < 0 || input.getVitaminB1mg() < 0 || input.getVitaminB12mg() < 0)
            throw new CarbsNegativeValuesException("Vitamin value cannot be negative");

        Carbs carbs = Carbs.builder()
                .vitaminAiu(input.getVitaminAiu())
                .vitaminB1mg(input.getVitaminB1mg())
                .vitaminB12mg(input.getVitaminB12mg())
                .build();

        carbsRepository.save(carbs);

        return CarbsCreateOutput.builder()
                .id(carbs.getCarbsId())
                .carbs(carbs)
                .build();
    }
}
