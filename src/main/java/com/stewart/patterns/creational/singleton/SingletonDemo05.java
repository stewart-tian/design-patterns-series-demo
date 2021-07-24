package com.stewart.patterns.creational.singleton;

/**
 * 懒汉式 静态内部类
 *
 * @author stewart
 */
public class SingletonDemo05 {

    private SingletonDemo05() {
    }

    public static SingletonDemo05 getInstance() {
        return SingletonDemo05Inner.INSTANCE;
    }

    /**
     * 由于JVM在加载外部类的过程中，是不会加载静态内部类的。只有内部类的属性/方法被调用时才会加载，并初始化其静态属性。
     * 静态属性由于被static修饰，保证只被实例化一次，并且严格保证实例化顺序。
     */
    private static class SingletonDemo05Inner {
        private static final SingletonDemo05 INSTANCE = new SingletonDemo05();
    }

}
