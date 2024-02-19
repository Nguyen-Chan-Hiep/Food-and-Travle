package com.service.FoodAndTravel.Service.FoodService;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.DTO.FoodDTO;
import com.service.FoodAndTravel.DTO.FoodDetailDTO;
import com.service.FoodAndTravel.Model.Food.Food;
import com.service.FoodAndTravel.Model.Food.FoodDetail;
import com.service.FoodAndTravel.Reponsitory.FoodReponsitory.FoodDetailRepo;
import com.service.FoodAndTravel.Reponsitory.FoodReponsitory.FoodRepo;
import com.service.FoodAndTravel.Reponsitory.LikeNumberRepo;
import com.service.FoodAndTravel.Service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FoodService extends BaseService<FoodRepo, Food> {
    private final FoodRepo repo;
    private final FoodDetailRepo foodDetailRepo;
    private final LikeNumberRepo likeNumberRepo;
    public FoodService(FoodRepo foodRepo, FoodRepo repo, FoodDetailRepo foodDetailRepo, LikeNumberRepo likeNumberRepo) {
        super(foodRepo);
        this.repo = repo;
        this.foodDetailRepo = foodDetailRepo;
        this.likeNumberRepo = likeNumberRepo;
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
        long likeNumber = likeNumberRepo.getLikeNumberByEntityAndCategory(result.getId(), Constants.Category.FOOD.toString());
        result.setLikeNumber(likeNumber);
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
                long likeNumber = likeNumberRepo.getLikeNumberByEntityAndCategory(foodDTO.getId(), Constants.Category.FOOD.toString());
                foodDTO.setLikeNumber(likeNumber);
                foodDTOS.add(foodDTO);
            });
        }
        return foodDTOS;
    }
}
