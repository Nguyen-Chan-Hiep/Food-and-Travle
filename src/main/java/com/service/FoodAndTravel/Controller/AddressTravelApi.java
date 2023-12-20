package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.AddressTravel;
import com.service.FoodAndTravel.Service.AddressTravelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel")
public class AddressTravelApi extends BaseController<AddressTravelService, AddressTravel>{

    public AddressTravelApi(AddressTravelService service) {
        super(service);
    }
}
