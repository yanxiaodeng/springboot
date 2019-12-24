package com.eden.springboot4webrestfulcrud.config;


import com.eden.springboot4webrestfulcrud.component.LoginHandlerInterceptor;
import com.eden.springboot4webrestfulcrud.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**这里是对spring mvc的一个扩展，只要标注@Configuration
 * 就是一个配置类，能够使用所有的自动配置，也能使用我们自己定义的配置
 * */
/**
 * @EnableWebMvc全面接管springmvc，
 * 这时候springboot对于springmvc的web模块配置全失效
 * */
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/eden 请求到success
        registry.addViewController("/eden").setViewName("success");
    }


    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }

    //自定义修改tomcat的配置文件
//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> MyCustomizer()
//    {
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>()
//        {
//            //定制嵌入式的Servlet容器相关的规则
//            @Override
//            public void customize(ConfigurableWebServerFactory factory) {
//                factory.setPort(8083);
//            }
//        };
//    }


}
