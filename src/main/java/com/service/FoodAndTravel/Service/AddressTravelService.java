package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.AddressTravel;
import com.service.FoodAndTravel.Reponsitory.AddressTravelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AddressTravelService {
    @Autowired
    private AddressTravelRepo addressTravelRepo;

    public List<AddressTravel> getAll(){
        try{
            List<AddressTravel> addressTravels = addressTravelRepo.findAll();
            return addressTravels;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public AddressTravel getById(long id) throws Exception {
        AddressTravel addressTravel = addressTravelRepo.findById(id).orElse(null);
        if (addressTravel == null){
            throw new Exception();
        }
        return addressTravel;
    }

//    public
}
