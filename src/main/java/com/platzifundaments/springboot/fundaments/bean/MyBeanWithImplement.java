package com.platzifundaments.springboot.fundaments.bean;

public class MyBeanWithImplement implements MyBeanWithProperties{

    private String name;
    private String surname;

    public MyBeanWithImplement(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String function() {
        return name + "-" + surname;
    }
}
