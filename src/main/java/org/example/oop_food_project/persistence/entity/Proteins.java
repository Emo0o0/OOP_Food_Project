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
public class Proteins {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer proteinsId;
    private int amount;
}
