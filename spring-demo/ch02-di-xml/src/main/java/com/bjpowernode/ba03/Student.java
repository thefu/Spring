package com.bjpowernode.ba03;

public class Student {

    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student() {
        System.out.println("spring会调用类的无参数构造方法创建对象");
    }

    public Student(String name, int age, School school) {
        System.out.println ( "=====Student有参数构造方法====" );
        //属性赋值
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public Student(String name) {
    }

    public void setName(String name) {
        this.name = name.toUpperCase ();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", school=" + school +
               '}';
    }
}
