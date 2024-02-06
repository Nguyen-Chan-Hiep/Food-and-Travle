package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Service.AddressTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/travel")
public class AddressTravelApi extends BaseController<AddressTravelService, AddressTravel>{

    @Autowired
    private AddressTravelService addressTravelService;
    public AddressTravelApi(AddressTravelService service) {
        super(service);
    }

    @GetMapping("/detail")
    public Object getDetail(@RequestParam("id") long id){
        return addressTravelService.getDetail(id);
    }
}
