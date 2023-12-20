package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Food;
import com.service.FoodAndTravel.Service.FoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodApi extends BaseController<FoodService, Food> {
    public FoodApi(FoodService service) {
        super(service);
    }
}
