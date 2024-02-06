package com.service.FoodAndTravel.Reponsitory.FoodReponsitory;

import com.service.FoodAndTravel.Model.Food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food, Long> {
    Optional<Food> findByIdAndStatus(long id, int status);
    List<Food> findByParentIdAndStatus(long pid, int status);
}
