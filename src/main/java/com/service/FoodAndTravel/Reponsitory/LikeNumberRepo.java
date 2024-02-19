package com.service.FoodAndTravel.Reponsitory;

import com.service.FoodAndTravel.Model.LikeNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeNumberRepo extends JpaRepository<LikeNumber, Long> {
    @Query(value = "select count(*) from like_number ln where ln.entity_id = :entityId and ln.category = :category and ln.liked = 1", nativeQuery = true)
    long getLikeNumberByEntityAndCategory(@Param("entityId") long entityId,
                                                 @Param("category") String category);
}
