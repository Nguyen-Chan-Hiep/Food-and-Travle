package com.service.FoodAndTravel.Model.User;

import com.service.FoodAndTravel.Model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Base {
    private String name;
    private String email;
    private String passWord;
}
