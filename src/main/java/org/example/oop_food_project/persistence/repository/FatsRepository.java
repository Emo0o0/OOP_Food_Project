package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Fats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatsRepository extends JpaRepository<Fats, Integer> {
}
