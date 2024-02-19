package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Service.TravelService.AddressTravelService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/travel")
public class AddressTravelApi extends BaseController<AddressTravelService, AddressTravel>{

    private final AddressTravelService addressTravelService;
    public AddressTravelApi(AddressTravelService service, AddressTravelService addressTravelService) {
        super(service);
        this.addressTravelService = addressTravelService;
    }

    @GetMapping("/detail")
    public Object getDetail(@RequestParam("id") long id){
        return addressTravelService.getDetail(id);
    }
}
