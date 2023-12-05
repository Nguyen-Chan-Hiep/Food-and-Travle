package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.AddressTravel;
import com.service.FoodAndTravel.Service.AddressTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity getById(@PathVariable("id") long id){
        try{
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            return ResponseEntity.of(Optional.empty());
        }
    }
}
