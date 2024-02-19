package com.service.FoodAndTravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FoodDTO extends BaseDTO{
    private String category;
    private String name;
    private long parentId;
    private String image;
    private String description;
    private FoodDetailDTO detail;
    private List<FoodDTO> children;
    private long likeNumber;
}
