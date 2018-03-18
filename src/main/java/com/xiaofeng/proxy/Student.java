package com.xiaofeng.proxy;

/**
 * Created by xiaofeng on 2018/3/16
 * Description:
 */
public class Student implements Person {
    @Override
    public void eat() {
        System.out.println("student eat...");
    }

    public static void main(String[] args) {
        Person person = new Student();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(person);
        Person proxy = (Person) myInvocationHandler.getProxy();
        proxy.eat();
    }
}