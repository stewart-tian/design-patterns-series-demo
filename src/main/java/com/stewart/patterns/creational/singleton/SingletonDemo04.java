package com.stewart.patterns.creational.singleton;

import java.io.Serializable;

/**
 * 饿汉式 双检索
 *
 * @author stewart
 */
public class SingletonDemo04 implements Serializable {

    /**
     * 由于java实例化一个对象不是原子性的，有可能因指令重排的导致空指针异常，
     * (在A线程还未完成对象创建时，先为instance分配了内存空间，但实际还未创建完成，
     * 此时线程B访问时，instance为未实例化完成但 !=null 的对象，从而可能导致空指针异常。)
     * 通过添加volatile防指令重拍避免空指针异常。
     */
    private static volatile SingletonDemo04 instance;

    private SingletonDemo04() {
    }

    /**
     * 双检索 避免多线程争夺资源
     */
    public static SingletonDemo04 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo04.class) {
                if (instance == null) {
                    instance = new SingletonDemo04();
                }
            }
        }
        return instance;
    }

}
