package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.AddressDetail;
import com.service.FoodAndTravel.Reponsitory.AddressDetailRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressDetailService extends BaseService<AddressDetailRepo, AddressDetail>{

    public AddressDetailService(AddressDetailRepo addressDetailRepo) {
        super(addressDetailRepo);
    }
}
