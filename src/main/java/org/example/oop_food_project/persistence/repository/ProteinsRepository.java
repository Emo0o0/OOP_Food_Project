package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Proteins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteinsRepository extends JpaRepository<Proteins, Integer> {
}
