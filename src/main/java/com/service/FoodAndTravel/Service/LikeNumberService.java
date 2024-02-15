package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.LikeNumber;
import com.service.FoodAndTravel.Reponsitory.LikeNumberRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LikeNumberService extends BaseService<LikeNumberRepo, LikeNumber>{
    public LikeNumberService(LikeNumberRepo likeNumberRepo) {
        super(likeNumberRepo);
    }
}
