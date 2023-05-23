package com.bjpowernode.ba02;

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
}
