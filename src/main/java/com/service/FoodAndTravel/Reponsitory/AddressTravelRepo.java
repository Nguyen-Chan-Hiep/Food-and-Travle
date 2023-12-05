package com.service.FoodAndTravel.Reponsitory;

import com.service.FoodAndTravel.Model.AddressTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTravelRepo extends JpaRepository<AddressTravel, Long> {

}
