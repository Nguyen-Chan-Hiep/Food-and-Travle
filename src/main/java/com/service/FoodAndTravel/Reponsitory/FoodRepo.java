package com.service.FoodAndTravel.Reponsitory;

import com.service.FoodAndTravel.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
}
