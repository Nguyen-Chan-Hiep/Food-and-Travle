package com.service.FoodAndTravel.Reponsitory.UserReponsitory;

import com.service.FoodAndTravel.Model.User.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Account, Long> {
    boolean existsByEmailAndPassWord(String email, String pass);
}
