package org.example.oop_food_project.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Carbs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer carbsId;
    private int vitaminAiu;
    private int vitaminB1mg;
    private int vitaminB12mg;
}
