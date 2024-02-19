package com.service.FoodAndTravel.Service.User;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Model.User.Account;
import com.service.FoodAndTravel.Reponsitory.UserReponsitory.UserRepo;
import com.service.FoodAndTravel.Service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

@Service
@Transactional
public class UserService extends BaseService<UserRepo, Account> {

    private final UserRepo repo;

    public UserService(UserRepo userRepo, UserRepo repo) {
        super(userRepo);
        this.repo = repo;
    }

    @Override
    public Object create(Account acc) {
        try{
            String password = deCodePassWord(acc.getPassWord());
            acc.setPassWord(password);
            return super.create(acc);
        } catch (Exception e){
            return new PersonalException("error", e.getMessage());
        }
    }

    public boolean checkLogin(Account account){
        try{
            String pass = deCodePassWord(account.getPassWord());
            return repo.existsByEmailAndPassWord(account.getEmail(), pass);
        } catch (Exception e){
            return false;
        }
    }

    public String deCodePassWord(String pass) throws Exception {
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(pass.getBytes(StandardCharsets.UTF_8));
        byte[] hashInBytes = salt.digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }
}
