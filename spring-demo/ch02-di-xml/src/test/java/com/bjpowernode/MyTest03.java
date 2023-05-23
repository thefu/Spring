package com.bjpowernode;

import com.bjpowernode.ba03.School;
import com.bjpowernode.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

public class MyTest03 {



    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext ( config );

        //从容器中获取Student对象
        Student myStudent = (Student) ac.getBean ( "myStudent3" );
        System.out.println("student对象="+myStudent);

        File myFile = (File) ac.getBean ( "myFile" );
        System.out.println ( "myFile=="+myFile.getName () );

    }

}
