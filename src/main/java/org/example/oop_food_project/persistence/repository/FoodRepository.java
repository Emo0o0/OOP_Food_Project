package org.example.oop_food_project.persistence.repository;

import org.example.oop_food_project.persistence.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query("select f from Food f where f.foodContentsPer100.calories.calories >= :calories")
    List<Food> findAllFoodWithHighCalories(int calories);

    @Query("select f from Food f where f.foodContentsPer100.proteins.amount >= :protein")
    List<Food> findAllFoodWithHighProtein(int protein);

    @Query("select f from Food f where f.foodContentsPer100.fats.monounsaturatedFatsGrams > 15 or f.foodContentsPer100.fats.polyunsaturatedFatsGrams > 10 or f.foodContentsPer100.fats.saturatedFatsGrams > 10 or f.foodContentsPer100.fats.transFatsGrams > 1")
    List<Food> findAllFoodWithHighFats();

    @Query("select f from Food f where f.foodContentsPer100.carbs.vitaminAiu > 3000 or f.foodContentsPer100.carbs.vitaminB1mg > 1.5 or f.foodContentsPer100.carbs.vitaminB12mg > 2.4")
    List<Food> findAllFoodWithHighVitamins();

    @Query("select f from Food f where f.foodContentsPer100.carbs.vitaminAiu > 3000")
    List<Food> findAllFoodWithHighVitaminA();

    @Query("select f from Food f where f.foodContentsPer100.carbs.vitaminB1mg > 1.5")
    List<Food> findAllFoodWithHighVitaminB1();

    @Query("select f from Food f where f.foodContentsPer100.carbs.vitaminB12mg > 2.4")
    List<Food> findAllFoodWithHighVitaminB12();

}
