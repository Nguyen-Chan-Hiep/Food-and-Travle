package com.service.FoodAndTravel.Reponsitory.FoodReponsitory;

import com.service.FoodAndTravel.Model.Food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
}
