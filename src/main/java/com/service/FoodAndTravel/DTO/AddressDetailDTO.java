package com.service.FoodAndTravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AddressDetailDTO extends BaseDTO {
    private long addressId;
    private String images;
    private double ticketPrice;
    private Date openTime;
    private Date closeTime;
    private String highlights;
    private String detailDescription;
}
