package com.platzifundaments.springboot.fundaments.caseuse;

import com.platzifundaments.springboot.fundaments.entity.User;
import com.platzifundaments.springboot.fundaments.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }


    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
