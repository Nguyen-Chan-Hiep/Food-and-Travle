package com.service.FoodAndTravel.Model.Travel;

import com.service.FoodAndTravel.DTO.AddressTravelDTO;
import com.service.FoodAndTravel.Model.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class AddressTravel extends Base {
    private String address;
    private String image;
    private String name;
    private long parentId;
    private String category;

    public AddressTravelDTO toDTO(AddressTravel addressTravel){
        AddressTravelDTO addressTravelDTO = new AddressTravelDTO();
        addressTravelDTO.setId(addressTravel.getId());
        addressTravelDTO.setStatus(addressTravel.getStatus());
        addressTravelDTO.setCreateBy(addressTravel.getCreateBy());
        addressTravelDTO.setCreateDate(addressTravel.getCreateDate());
        addressTravelDTO.setUpdateBy(addressTravel.getUpdateBy());
        addressTravelDTO.setModifyDate(addressTravel.getModifyDate());
        addressTravelDTO.setAddress(addressTravel.getAddress());
        addressTravelDTO.setImage(addressTravel.getImage());
        addressTravelDTO.setName(addressTravel.getName());
        addressTravelDTO.setParentId(addressTravel.getParentId());
        addressTravelDTO.setCategory(addressTravel.getCategory());
        return addressTravelDTO;
    }
}
