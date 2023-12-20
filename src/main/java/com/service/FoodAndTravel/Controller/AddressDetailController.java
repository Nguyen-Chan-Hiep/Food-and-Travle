package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.AddressDetail;
import com.service.FoodAndTravel.Service.AddressDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address-detail")
public class AddressDetailController extends BaseController<AddressDetailService, AddressDetail>{
    public AddressDetailController(AddressDetailService service) {
        super(service);
    }
}
