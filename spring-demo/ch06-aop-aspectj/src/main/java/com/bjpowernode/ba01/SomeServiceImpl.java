package com.bjpowernode.ba01;

//目标类
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name,Integer age) {
        //做的是给doSome()方法增加一个功能，在doSome执行之前，输出方法执行的时间
        System.out.println("====目标方法doSome()====");
    }
}
