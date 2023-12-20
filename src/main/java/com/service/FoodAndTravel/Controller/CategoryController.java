package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Category;
import com.service.FoodAndTravel.Service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<CategoryService, Category>{
    public CategoryController(CategoryService service) {
        super(service);
    }
}
