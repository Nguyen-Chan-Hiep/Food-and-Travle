package com.service.FoodAndTravel.Model.Food;

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
}
