package org.example.oop_food_project.core.service.fats;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.fats.FatsCreateInput;
import org.example.oop_food_project.api.inputoutput.fats.FatsCreateOperation;
import org.example.oop_food_project.api.inputoutput.fats.FatsCreateOutput;
import org.example.oop_food_project.core.exception.fats.FatsNegativeValuesException;
import org.example.oop_food_project.persistence.entity.Fats;
import org.example.oop_food_project.persistence.repository.FatsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FatsCreateOperationProcessor implements FatsCreateOperation {

    private final FatsRepository fatsRepository;

    @Override
    public FatsCreateOutput process(FatsCreateInput input) {

//        return null;
        if (input.getMonounsaturatedFatsGrams() < 0 ||
                input.getSaturatedFatsGrams() < 0 ||
                input.getPolyunsaturatedFatsGrams() < 0 ||
                input.getTransFatsGrams() < 0)
            throw new FatsNegativeValuesException("Fats values cannot be negative");

        Fats fats = Fats.builder()
                .monounsaturatedFatsGrams(input.getMonounsaturatedFatsGrams())
                .polyunsaturatedFatsGrams(input.getPolyunsaturatedFatsGrams())
                .saturatedFatsGrams(input.getSaturatedFatsGrams())
                .transFatsGrams(input.getTransFatsGrams())
                .build();

        fatsRepository.save(fats);

        return FatsCreateOutput.builder()
                .id(fats.getFatsId())
                .build();
    }
}
