package com.platzifundaments.springboot.fundaments.configuration;

import com.platzifundaments.springboot.fundaments.caseuse.GetUser;
import com.platzifundaments.springboot.fundaments.caseuse.GetUserImplement;
import com.platzifundaments.springboot.fundaments.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
