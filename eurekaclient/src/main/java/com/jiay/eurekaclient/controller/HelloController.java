package com.jiay.eurekaclient.controller;

import com.jiay.eurekaclient.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("index")
    public String index() {
        //测试异常处理
        //int a = 1/0;
        return "hello,port:" + port;
    }

    //异常处理
    @ExceptionHandler
    public Map doError(Exception e) throws Exception{
        Map map = new HashMap();
        if(e instanceof CustomException){
            map.put("code",((CustomException) e).getCode());
            map.put("errmsg",((CustomException) e).getErrmsg());
        }else {
            map.put("code",500);
            map.put("errmsg",e.getMessage());
        }
        e.printStackTrace();
        return map;
    }

}
