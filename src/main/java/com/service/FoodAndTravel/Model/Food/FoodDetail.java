package com.service.FoodAndTravel.Model.Food;

import com.service.FoodAndTravel.Model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@EqualsAndHashCode(callSuper = false)
public class FoodDetail extends Base {
    private long foodId;
    private List<String> images;
    private String ingredients; // nguyen lieu
    private String processing; // cach che bien
    private String detailDescription;
}
