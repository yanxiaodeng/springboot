package com.eden.springboot4webrestfulcrud.controller;

import com.eden.springboot4webrestfulcrud.exception.UserNotExitException;
import com.sun.deploy.net.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1.这种情况下，无论是客户端还是浏览器返回的都是json的数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String,Object> handlerException(Exception e)
//    {
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexit");
//        map.put("message",e.getMessage());
//        return map;
//    }



    @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request)
    {
        Map<String,Object> map=new HashMap<>();
        /**
         *   这里要传入我们自己的默认的状态码
         *   如果没有传，那么就是默认的状态码200
         *   要不就不会地回到自己设置的界面
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexit");
        map.put("message",e.getMessage());

        //最终是要到这里来的，也就是添加我们自己需要的信息
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
