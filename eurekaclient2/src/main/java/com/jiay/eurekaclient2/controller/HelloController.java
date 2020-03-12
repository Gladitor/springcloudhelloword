package com.jiay.eurekaclient2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("index")
    public String index() {
        return "hello,port:" + port;
    }

    //异常处理
    @ExceptionHandler
    public Map doError(Exception e) throws Exception{
        Map map = new HashMap();
        map.put("code",500);
        map.put("errmsg",e.getMessage());
        e.printStackTrace();
        return map;
    }

}
