package com.service.FoodAndTravel.Reponsitory;

import com.service.FoodAndTravel.Model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepo extends JpaRepository<Reviews, Long> {
}
