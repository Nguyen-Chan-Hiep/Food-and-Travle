package com.service.FoodAndTravel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetail extends Base {
    private String images;
    private String description;
    private double ticketPrice;
    private Date openTime;
    private Date closeTime;
}
