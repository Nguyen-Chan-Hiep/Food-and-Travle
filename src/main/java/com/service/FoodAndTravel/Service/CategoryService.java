package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.Category;
import com.service.FoodAndTravel.Reponsitory.CategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService extends BaseService<CategoryRepo, Category>{
    public CategoryService(CategoryRepo categoryRepo) {
        super(categoryRepo);
    }
}
