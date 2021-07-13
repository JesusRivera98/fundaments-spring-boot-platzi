package com.platzifundaments.springboot.fundaments.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void greet() {
        System.out.println("Hello world from my component two");
    }
}
