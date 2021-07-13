package com.platzifundaments.springboot.fundaments.configuration;

import com.platzifundaments.springboot.fundaments.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }
    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
