package com.bjpowernode.ba05;

import com.bjpowernode.ba02.Student;

//目标类
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name,Integer age) {
        //做的是给doSome()方法增加一个功能，在doSome执行之前，输出方法执行的时间
        System.out.println("====目标方法doSome()====");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("====目标方法doOther()====");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {

        Student student = new Student ();
        student.setAge ( 20 );
        student.setName ( "王宇豪" );
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println ( "=======业务方法doFirst()=====" );
        return "doFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("执行业务方法doSecond()方法！"+(10/0));
    }

    @Override
    public void doThird() {
        System.out.println("执行业务方法doThird()方法！");
    }
}
