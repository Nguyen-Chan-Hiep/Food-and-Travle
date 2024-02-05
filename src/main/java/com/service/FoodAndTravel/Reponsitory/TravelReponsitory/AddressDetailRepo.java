package com.service.FoodAndTravel.Reponsitory.TravelReponsitory;

import com.service.FoodAndTravel.Model.Travel.AddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressDetailRepo extends JpaRepository<AddressDetail, Long> {
    Optional<AddressDetail> findByAddressIdAndStatus(long addressId, int status);
}
