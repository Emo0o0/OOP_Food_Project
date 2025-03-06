package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query("SELECT f FROM Food f WHERE f.foodContentsPer100.carbs.vitaminAiu > :amount")
    List<Food> findByVitaminAiu(@Param("amount") int amount);


}
