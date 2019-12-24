package com.eden.springboot.config;

import com.eden.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 1.@Configuration指明当前类就是一个配置类，就是代替之前的spring的配置文件
*   我们知道一般来说，在配置文件里面使用的是<bean></bean>的方式来实现配置
* */
@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService()
    {
        System.out.println("配置类@Bean给容器里面添加组件了....");
        return new HelloService();
    }

}
