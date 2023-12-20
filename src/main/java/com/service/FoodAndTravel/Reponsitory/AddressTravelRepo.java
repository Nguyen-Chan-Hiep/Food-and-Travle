package com.service.FoodAndTravel.Reponsitory;

import com.service.FoodAndTravel.Model.AddressTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTravelRepo extends JpaRepository<AddressTravel, Long> {
    @Query("select at from AddressTravel at where at.name like :name " +
            "and at.address like :address " +
            "and at.status = :status " +
            "and at.category like :category")
    AddressTravel checkExist(@Param("name") String name,
                                 @Param("address") String address,
                                 @Param("status") int status,
                                 @Param("category") String categoryCode);
}
