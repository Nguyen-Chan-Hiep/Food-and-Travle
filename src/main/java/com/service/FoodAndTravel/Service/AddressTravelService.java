package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.Model.AddressTravel;
import com.service.FoodAndTravel.Reponsitory.AddressTravelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Transactional
public class AddressTravelService extends BaseService<AddressTravelRepo, AddressTravel> {

    @Autowired
    private AddressTravelRepo repo;

    public AddressTravelService(AddressTravelRepo addressTravelRepo) {
        super(addressTravelRepo);
    }

    @Override
    public Object create(AddressTravel o) {
        try {
            AddressTravel addressTravel = repo.checkExist(o.getName(), o.getAddress(), Constants.ACTIVE_STATUS, Constants.Category.TRAVEL.toString());
            if (addressTravel != null) {
                return new PersonalException("error", "Address travel is already exists");
            }
            o.setCreateDate(new Date());
            o.setCreateBy("system");
            o.setStatus(1);
            o = repo.save(o);
            return o;
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }

}
