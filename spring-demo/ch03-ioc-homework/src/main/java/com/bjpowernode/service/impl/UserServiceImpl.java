package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    //引用类型，在xml文件给属性赋值，要求属性需要有set方法
    //@Autowired
    //@Qualifier("mysqlDao")
    @Resource(name = "oracleDao")
    private UserDao dao = null;

    //set方法可以不需要
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        //调用dao的方法
        dao.insertUser ( user );

    }
}
