package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Calories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaloriesRepository extends JpaRepository<Calories, Integer> {
}
