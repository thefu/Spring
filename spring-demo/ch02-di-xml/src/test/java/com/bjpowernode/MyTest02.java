package com.bjpowernode;

import com.bjpowernode.ba02.School;
import com.bjpowernode.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest02 {



    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext ( config );

        //从容器中获取Student对象
        Student myStudent = (Student) ac.getBean ( "myStudent" );
        System.out.println("student对象="+myStudent);

        myStudent.setAge ( 31 );
        System.out.println("getAge"+myStudent.getAge());

        Date myDate = (Date) ac.getBean ( "myDate" );
        System.out.println("myDate:"+myDate);


    }

    @Test
    public void test02(){
        System.out.println ( "====test02====" );

        Student student = new Student ();
        student.setName ( "张三" );
        student.setAge ( 20 );

        School school = new School ();
        school.setName ( "四川农业大学" );
        school.setAddress ( "雅安" );

        student.setSchool ( school );

        System.out.println ( "student==="+ student );
    }



}
