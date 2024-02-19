package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Food.Food;
import com.service.FoodAndTravel.Service.FoodService.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodApi extends BaseController<FoodService, Food> {
    @Autowired
    private FoodService foodService;
    public FoodApi(FoodService service) {
        super(service);
    }
    @GetMapping("/detail")
    public Object getDetail(@RequestParam("id") long id){
        return foodService.getDetail(id);
    }
}
