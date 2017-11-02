package com.jvm;

/**
 * Created by ListenYoung on 2017/10/31.
 */

/**
 * 静态分派
 * 重载发生在编译器，并且签名匹配是模糊的
 * 策略模式就是动态分派
 */
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human human){
        System.out.println("hello, human");
    }
    public void sayHello(Man man){
        System.out.println("hello, man");
    }
    public void sayHello(Woman woman){
        System.out.println("hello, woman");
    }

    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
        //will say human
    }
}
