package com.service.FoodAndTravel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class AddressDetail extends Base{
    private long addressId;
    private String image;
    private String description;
    private double ticketPrice;
    private Date openTime;
    private Date closeTime;
}
