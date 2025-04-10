package org.example.oop_food_project.core.service.proteins;

import lombok.RequiredArgsConstructor;
import org.example.oop_food_project.api.inputoutput.proteins.ProteinsCreateInput;
import org.example.oop_food_project.api.inputoutput.proteins.ProteinsCreateOperation;
import org.example.oop_food_project.api.inputoutput.proteins.ProteinsCreateOutput;
import org.example.oop_food_project.core.exception.proteins.ProteinsBlankDescriptionException;
import org.example.oop_food_project.persistence.entity.Proteins;
import org.example.oop_food_project.persistence.repository.ProteinsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProteinsCreateOperationProcessor implements ProteinsCreateOperation {

    private final ProteinsRepository proteinsRepository;

    @Override
    public ProteinsCreateOutput process(ProteinsCreateInput input) {

        if (input.getAmount() < 0)
            throw new ProteinsBlankDescriptionException("Proteins amount cannot be negative");

        Proteins proteins = Proteins.builder()
                .amount(input.getAmount())
                .build();

        proteinsRepository.save(proteins);

        return ProteinsCreateOutput.builder()
                .id(proteins.getProteinsId())
                .proteins(proteins)
                .build();
    }
}
