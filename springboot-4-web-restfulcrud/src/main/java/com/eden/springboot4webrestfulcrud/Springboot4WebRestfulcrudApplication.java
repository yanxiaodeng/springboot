package com.eden.springboot4webrestfulcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Springboot4WebRestfulcrudApplication{

    public static void main(String[] args) {
        SpringApplication.run(Springboot4WebRestfulcrudApplication.class, args);
    }
        //把自己的的视图解析器注册到容器里面,首先解析自己定义的视图解析器
    @Bean
    public ViewResolver myViewResolver()
    {
        return new myViewResolver();
    }

    private static class myViewResolver implements ViewResolver
    {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}

