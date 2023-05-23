package com.bjpowernode.util;

import java.util.Date;

public class ServiceTools {

    public static void doLog(){
        System.out.println( "执行业务的时间" + new Date ());
    }

    public static void doTrans(){
        System.out.println("方法执行完毕后，提交事务！");
    }
}
