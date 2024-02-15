package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Model.Reviews;
import com.service.FoodAndTravel.Reponsitory.ReviewsRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewService extends BaseService<ReviewsRepo, Reviews>{
    public ReviewService(ReviewsRepo reviewsRepo) {
        super(reviewsRepo);
    }
}
