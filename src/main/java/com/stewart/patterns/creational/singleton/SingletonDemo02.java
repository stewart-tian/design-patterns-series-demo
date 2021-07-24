package com.stewart.patterns.creational.singleton;

/**
 * 饿汉式 静态代码块
 *
 * @author stewart
 */
public class SingletonDemo02 {

    private static final SingletonDemo02 INSTANCE;

    static {
        INSTANCE = new SingletonDemo02();
    }

    private SingletonDemo02() {
    }

    public static SingletonDemo02 getInstance() {
        return INSTANCE;
    }

}
