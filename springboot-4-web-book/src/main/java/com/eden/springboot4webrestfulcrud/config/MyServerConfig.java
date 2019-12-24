package com.eden.springboot4webrestfulcrud.config;

import com.eden.springboot4webrestfulcrud.filter.MyFilter;
import com.eden.springboot4webrestfulcrud.listener.MyListener;
import com.eden.springboot4webrestfulcrud.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration
public class MyServerConfig {


    //注册三大组件
    //1.注册Servlet
    @Bean
    public ServletRegistrationBean myServlet()
    {
        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }

    //2.注册Filter
    @Bean
    public FilterRegistrationBean MyFiletr()
    {
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/heelo","/myServlet"));
        return filterRegistrationBean;
    }

    //3.注册Listener
     @Bean
     public ServletListenerRegistrationBean MyListener()
     {
         ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean=  new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return servletListenerRegistrationBean;
     }

    //配置嵌入式的servlet的容器
    //自定义修改tomcat的配置文件
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> MyCustomizer()
    {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>()
        {
            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }
}
