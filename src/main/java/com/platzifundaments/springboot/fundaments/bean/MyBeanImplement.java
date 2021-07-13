package com.platzifundaments.springboot.fundaments.bean;

public class MyBeanImplement implements  MyBean{
    @Override
    public void print() {
        System.out.println("Hello from my own implementation of bean");
    }
}
