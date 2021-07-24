package com.stewart.patterns.creational.singleton;

import java.io.Serializable;

/**
 * 解决单例模式下序列化，反序列化破坏单例问题
 *
 * @author stewart
 */
public class SingletonExt01 implements Serializable {

    private static volatile SingletonExt01 instance;

    private SingletonExt01(){}

    public static SingletonExt01 getInstance() {
        if (instance == null) {
            synchronized (SingletonExt01.class) {
                if (instance == null) {
                    instance = new SingletonExt01();
                }
            }
        }
        return instance;
    }

    /**
     * 对象反序列化时，会先判断该类是否有readResolve()方法，有则直接调用该方法来反序列化
     */
    public Object readResolve() {
        return instance;
    }

}
