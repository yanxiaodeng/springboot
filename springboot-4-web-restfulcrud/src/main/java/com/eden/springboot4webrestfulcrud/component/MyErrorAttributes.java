package com.eden.springboot4webrestfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器里面添加我们自己定义的ErrorAttributes
public class MyErrorAttributes extends DefaultErrorAttributes {
    /**
     * 返回的字段map就是页面和json都能获取的数据，
     * 也就是说这里的数据就是所有的错误的数据，这个类的作用就是实现对于
     * 这种自定义的错误的数据类型的定义
     *
     *
     *我们的错误处理器从获取一个map
     * */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map=super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("MyErrorInfo","自己添加的错误信息，出现在json里面");

        //我们的异常类携带的数据
        Map<String, Object> ext= (Map<String, Object>) webRequest.getAttribute("ext",0);
        //这里就是返回给handler一个我们自己定义的map
        map.put("ext",ext);
        return map;
    }
}
