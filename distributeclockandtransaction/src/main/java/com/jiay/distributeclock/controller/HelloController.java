package com.jiay.distributeclock.controller;

import com.jiay.distributeclock.lock.DistributeLockHandler;
import com.jiay.distributeclock.lock.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private DistributeLockHandler distributeLockHandler;

    @RequestMapping("index")
    public String index(){
        Lock lock=new Lock("lynn","min");
        if(distributeLockHandler.tryLock(lock)){
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法");
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            distributeLockHandler.releaseLock(lock);
        }
        return "hello world!";
    }
}
