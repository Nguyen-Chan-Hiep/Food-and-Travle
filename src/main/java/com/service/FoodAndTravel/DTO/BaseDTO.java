package com.service.FoodAndTravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    private long id;
    private int status;
    private Date createDate;
    private String createBy;
    private Date modifyDate;
    private String updateBy;
}
