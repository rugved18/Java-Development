package com.shopping.mall.User.testClass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class ValueCheck {
    @Value("${prop.name}")
    String name;


    public void test(){
        System.out.println("my name is "+name);
    }
}
