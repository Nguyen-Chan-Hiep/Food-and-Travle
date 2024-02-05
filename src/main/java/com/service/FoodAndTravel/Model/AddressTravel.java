package com.service.FoodAndTravel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class AddressTravel extends AddressDetail {
    private String address;
    private String image;
    private String name;
    private int status;
    private String category;
}
