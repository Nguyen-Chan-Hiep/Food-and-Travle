package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.DTO.AddressTravelDTO;
import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Service.AddressTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class AddressTravelApi extends BaseController<AddressTravelService, AddressTravel>{

    private final AddressTravelService service;

    public AddressTravelApi(AddressTravelService service) {
        super(service);
        this.service = service;
    }

//    @GetMapping("/detail")
//    public Object getDetail(@RequestParam("id") long id){
//        return service.getDetail(id);
//    }
}
