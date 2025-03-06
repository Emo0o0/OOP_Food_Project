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
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer foodId;
    @Column(nullable = false)
    private String product;
    @Column(nullable = false)
    private String productType;
    @OneToOne(optional = false)
    private FoodContents foodContentsPer100;
}
