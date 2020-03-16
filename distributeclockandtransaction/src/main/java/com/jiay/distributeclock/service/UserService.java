package com.jiay.distributeclock.service;

import com.jiay.distributeclock.bean.User;
import com.jiay.distributeclock.mapper.test1.UserMapper1;
import com.jiay.distributeclock.mapper.test2.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;

    @Transactional
    public void addUser(User user)throws Exception{
        userMapper1.addUser(user.getName(),user.getAge());
        //int a = 1/0;
        userMapper2.addUser(user.getName(),user.getAge());
    }
}
