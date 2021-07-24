package com.stewart.patterns.creational.singleton;

/**
 * 懒汉式 同步方法
 *
 * @author stewart
 */
public class SingletonDemo03 {

    private static SingletonDemo03 instance;

    private SingletonDemo03() {
    }

    /**
     * 不添加synchronized 会有线程安全问题
     * 添加后会有锁的开销，影响性能
     */
    public static synchronized SingletonDemo03 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo03();
        }
        return instance;
    }

}
