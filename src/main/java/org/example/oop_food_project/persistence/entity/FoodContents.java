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
public class FoodContents {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer foodContentsId;
    @OneToOne
    private Carbs carbs;
    @OneToOne
    private Proteins proteins;
    @OneToOne
    private Fats fats;
    @OneToOne
    private Calories calories;
}
