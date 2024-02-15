package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Reviews;
import com.service.FoodAndTravel.Service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reviews")
public class ReviewsAPI extends BaseController<ReviewService, Reviews>{
    public ReviewsAPI(ReviewService service) {
        super(service);
    }
}
