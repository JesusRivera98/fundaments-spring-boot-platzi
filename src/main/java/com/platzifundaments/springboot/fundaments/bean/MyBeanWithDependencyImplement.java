package com.platzifundaments.springboot.fundaments.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency{

    Log LOGGER  = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("We have entered the printWithDependency method");
        int number = 1;
        LOGGER.debug("The number sent as a parameter to the operation dependency is: " + number);
        System.out.println(myOperation.sum(number));
        System.out.println("Hello from the implementation of a bean with dependency");
    }
}
