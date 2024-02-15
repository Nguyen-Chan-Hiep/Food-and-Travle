package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.LikeNumber;
import com.service.FoodAndTravel.Service.LikeNumberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("like-number")
public class LikeNumberAPI extends BaseController<LikeNumberService, LikeNumber>{
    public LikeNumberAPI(LikeNumberService service) {
        super(service);
    }
}
