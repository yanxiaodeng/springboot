package com.eden.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
1.@ImportResource(locations = {"classpath:beans.xml"})导入spring的配置文件自定义的
* */
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class Springboot1ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1ConfigApplication.class, args);
    }

}
