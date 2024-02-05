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
public class AddressTravelDTO extends BaseDTO {
    private String address;
    private String image;
    private String name;
    private long parentId;
    private int status;
    private String category;
    private AddressDetailDTO detail;
    private List<AddressTravelDTO> children;
}
