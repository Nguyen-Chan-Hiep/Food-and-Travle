package com.service.FoodAndTravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FoodDetailDTO extends BaseDTO {
    private long foodId;
    private List<String> images;
    private String ingredients; // nguyen lieu
    private String processing; // cach che bien
    private String detailDescription;
}
