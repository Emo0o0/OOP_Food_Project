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
public class Calories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caloriesId;
    private int calories;
}
