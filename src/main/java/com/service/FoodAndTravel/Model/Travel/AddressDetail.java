package com.service.FoodAndTravel.Model.Travel;

import com.service.FoodAndTravel.DTO.AddressDetailDTO;
import com.service.FoodAndTravel.Model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetail extends Base {
    private long addressId;
    private String images;
    private double ticketPrice;
    private Date openTime;
    private Date closeTime;
    private String highlights;
    private String detailDescription;

    public AddressDetailDTO toDTO(AddressDetail addressDetail){
        AddressDetailDTO addressDetailDTO = new AddressDetailDTO();
        addressDetailDTO.setId(addressDetail.getId());
        addressDetailDTO.setCreateBy(addressDetail.getCreateBy());
        addressDetailDTO.setCreateDate(addressDetail.getCreateDate());
        addressDetailDTO.setUpdateBy(addressDetail.getUpdateBy());
        addressDetailDTO.setModifyDate(addressDetail.getModifyDate());
        addressDetailDTO.setAddressId(addressDetail.getAddressId());
        addressDetailDTO.setImages(addressDetail.getImages());
        addressDetailDTO.setTicketPrice(addressDetail.getTicketPrice());
        addressDetailDTO.setOpenTime(addressDetail.getOpenTime());
        addressDetailDTO.setCloseTime(addressDetail.getCloseTime());
        addressDetailDTO.setHighlights(addressDetail.getHighlights());
        addressDetailDTO.setDetailDescription(addressDetail.getDetailDescription());
        return addressDetailDTO;
    }
}
