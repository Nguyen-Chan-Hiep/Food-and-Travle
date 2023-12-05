package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.AddressTravel;
import com.service.FoodAndTravel.Service.AddressTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class AddressTravelApi {

    @Autowired
    private AddressTravelService service;

    @GetMapping("/get-all")
    public List<AddressTravel> getAll(){
        return service.getAll();
    }

    @GetMapping("/find-by-id/{id}")
    public AddressTravel getById(@PathVariable("id") long id){
        return service.getById(id);
    }
}
