package com.service.FoodAndTravel.Model.Food;

import com.service.FoodAndTravel.DTO.AddressDetailDTO;
import com.service.FoodAndTravel.DTO.FoodDetailDTO;
import com.service.FoodAndTravel.Model.Base;
import com.service.FoodAndTravel.Model.Travel.AddressDetail;
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

    public FoodDetailDTO toDTO(FoodDetail foodDetail){
        FoodDetailDTO foodDetailDTO = new FoodDetailDTO();
        foodDetailDTO.setId(foodDetail.getId());
        foodDetailDTO.setCreateBy(foodDetail.getCreateBy());
        foodDetailDTO.setCreateDate(foodDetail.getCreateDate());
        foodDetailDTO.setUpdateBy(foodDetail.getUpdateBy());
        foodDetailDTO.setModifyDate(foodDetail.getModifyDate());
        foodDetailDTO.setFoodId(foodDetail.getFoodId());
        foodDetailDTO.setImages(foodDetail.getImages());
        foodDetailDTO.setIngredients(foodDetail.getIngredients());
        foodDetailDTO.setProcessing(foodDetail.getProcessing());
        foodDetailDTO.setDetailDescription(foodDetail.getDetailDescription());
        return foodDetailDTO;
    }
}
