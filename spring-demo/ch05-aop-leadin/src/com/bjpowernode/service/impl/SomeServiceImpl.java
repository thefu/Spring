package com.bjpowernode.service.impl;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.util.ServiceTools;

import java.util.Date;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        //ServiceTools.doLog ();
        System.out.println("执行业务方法doSome！");

        //方法的最后，提交事务
        //ServiceTools.doTrans ();
    }

    @Override
    public void doOther() {
        //ServiceTools.doLog ();
        System.out.println("执行业务方法doOther！");

        //方法的最后，提交事务
        //ServiceTools.doTrans ();
    }
}
