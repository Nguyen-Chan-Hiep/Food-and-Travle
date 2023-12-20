package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.Food;
import com.service.FoodAndTravel.Reponsitory.FoodRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FoodService extends BaseService<FoodRepo, Food>{
    public FoodService(FoodRepo foodRepo) {
        super(foodRepo);
    }
}
