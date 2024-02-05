package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.Food.Food;
import com.service.FoodAndTravel.Reponsitory.FoodReponsitory.FoodRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FoodService extends BaseService<FoodRepo, Food>{
    public FoodService(FoodRepo foodRepo) {
        super(foodRepo);
    }
}
