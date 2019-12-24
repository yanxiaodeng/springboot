package com.eden.springboot;

import com.eden.springboot.bean.Person;
import com.sun.glass.ui.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot1ConfigApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void testHelloService()
    {
        boolean b=ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
