package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.DTO.AddressDetailDTO;
import com.service.FoodAndTravel.DTO.AddressTravelDTO;
import com.service.FoodAndTravel.DTO.FoodDTO;
import com.service.FoodAndTravel.DTO.FoodDetailDTO;
import com.service.FoodAndTravel.Model.Food.Food;
import com.service.FoodAndTravel.Model.Food.FoodDetail;
import com.service.FoodAndTravel.Model.Travel.AddressDetail;
import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Reponsitory.FoodReponsitory.FoodDetailRepo;
import com.service.FoodAndTravel.Reponsitory.FoodReponsitory.FoodRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FoodService extends BaseService<FoodRepo, Food>{
    @Autowired
    private FoodRepo repo;
    @Autowired
    private FoodDetailRepo foodDetailRepo;
    public FoodService(FoodRepo foodRepo) {
        super(foodRepo);
    }

    public Object getDetail(long id){
        Food food = repo.findByIdAndStatus(id, Constants.ACTIVE_STATUS).orElse(null);
        if (food == null){
            return new PersonalException("error", "Food not found");
        }
        Food food1 = new Food();
        FoodDetail detail = new FoodDetail();
        FoodDTO result = food1.toDTO(food);
        FoodDetail foodDetail = foodDetailRepo.findByFoodIdAndStatus(food.getId(), Constants.ACTIVE_STATUS).orElse(null);
        if (foodDetail != null){
            FoodDetailDTO foodDetailDTO = detail.toDTO(foodDetail);
            result.setDetail(foodDetailDTO);
        } else {
            result.setDetail(null);
        }
        result.setChildren(getChild(result));
        return result;
    }

    public List<FoodDTO> getChild(FoodDTO dto){
        Food travel = new Food();
        FoodDetail detail = new FoodDetail();
        List<Food> listChild = repo.findByParentIdAndStatus(dto.getId(), Constants.ACTIVE_STATUS);
        List<FoodDTO> foodDTOS = new ArrayList<>();
        if (!listChild.isEmpty()){
            listChild.forEach(child -> {
                FoodDTO foodDTO = travel.toDTO(child);
                List<FoodDTO> children = getChild(foodDTO);
                FoodDetail foodDetail = foodDetailRepo.findByFoodIdAndStatus(dto.getId(), Constants.ACTIVE_STATUS).orElse(null);
                if (foodDetail != null){
                    FoodDetailDTO foodDetailDTO = detail.toDTO(foodDetail);
                    foodDTO.setDetail(foodDetailDTO);
                } else {
                    foodDTO.setDetail(null);
                }
                foodDTO.setChildren(children);
                foodDTOS.add(foodDTO);
            });
        }
        return foodDTOS;
    }
}
