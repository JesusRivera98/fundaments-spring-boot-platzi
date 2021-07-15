package com.platzifundaments.springboot.fundaments.caseuse;

import com.platzifundaments.springboot.fundaments.entity.User;
import com.platzifundaments.springboot.fundaments.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
