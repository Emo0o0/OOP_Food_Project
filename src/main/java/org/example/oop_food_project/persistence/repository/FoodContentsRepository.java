package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.FoodContents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodContentsRepository extends JpaRepository<FoodContents, Integer> {
}
