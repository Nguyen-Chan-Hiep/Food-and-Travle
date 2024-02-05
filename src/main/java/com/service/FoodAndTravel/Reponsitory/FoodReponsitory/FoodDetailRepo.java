package com.service.FoodAndTravel.Reponsitory.FoodReponsitory;

import com.service.FoodAndTravel.Model.Food.FoodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDetailRepo extends JpaRepository<FoodDetail, Long> {
}
