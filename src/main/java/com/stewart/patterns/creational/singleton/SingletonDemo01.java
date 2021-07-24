package com.stewart.patterns.creational.singleton;

/**
 * 饿汉式 静态变量方式
 *
 * @author stewart
 */
public class SingletonDemo01 {

    private static final SingletonDemo01 INSTANCE = new SingletonDemo01();

    private SingletonDemo01() {
    }

    public static SingletonDemo01 getInstance(){
        return INSTANCE;
    }

}
