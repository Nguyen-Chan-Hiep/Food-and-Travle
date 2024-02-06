package com.service.FoodAndTravel.Reponsitory.FoodReponsitory;

import com.service.FoodAndTravel.Model.Food.FoodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodDetailRepo extends JpaRepository<FoodDetail, Long> {
    Optional<FoodDetail> findByFoodIdAndStatus(Long id, int status);
}
