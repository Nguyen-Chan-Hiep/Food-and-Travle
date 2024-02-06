package com.service.FoodAndTravel.Model.Food;

import com.service.FoodAndTravel.DTO.FoodDTO;
import com.service.FoodAndTravel.Model.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Food extends Base {
    private String category;
    private String name;
    private long parentId;
    private String image;
    private String description;

    public FoodDTO toDTO(Food food) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setCreateBy(food.getCreateBy());
        foodDTO.setCreateDate(food.getCreateDate());
        foodDTO.setUpdateBy(food.getUpdateBy());
        foodDTO.setModifyDate(food.getModifyDate());
        foodDTO.setCategory(food.getCategory());
        foodDTO.setName(food.getName());
        foodDTO.setParentId(food.getParentId());
        foodDTO.setImage(food.getImage());
        foodDTO.setDescription(food.getDescription());
        return foodDTO;
    }
}
