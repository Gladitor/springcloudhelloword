package com.jiay.distributeclock.controller;

import com.jiay.distributeclock.redlock.AquiredLockWorker;
import com.jiay.distributeclock.redlock.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloRedisson")
public class HelloControllerForRedisson {

    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("index")
    public String index()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {

            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello world!";
    }
}
