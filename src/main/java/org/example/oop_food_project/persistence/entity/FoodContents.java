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
    @OneToOne(optional = false)
    private Carbs carbs;
    @OneToOne(optional = false)
    private Proteins proteins;
    @OneToOne(optional = false)
    private Fats fats;
    @OneToOne(optional = false)
    private Calories calories;
}
