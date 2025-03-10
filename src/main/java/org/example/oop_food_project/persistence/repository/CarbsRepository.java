package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Carbs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarbsRepository extends JpaRepository<Carbs, Integer> {
}
