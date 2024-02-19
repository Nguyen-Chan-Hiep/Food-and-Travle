package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.User.Account;
import com.service.FoodAndTravel.Service.User.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class UserAPI extends BaseController<UserService, Account>{

    private final UserService userService;
    public UserAPI(UserService service, UserService userService) {
        super(service);
        this.userService = userService;
    }

    @PostMapping("/login")
    public boolean checkLogin(@RequestBody Account account){
        return userService.checkLogin(account);
    }
}
