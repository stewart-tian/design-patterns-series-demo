package com.stewart.patterns.creational.singleton;

import java.io.Serializable;

/**
 * 反射破坏单例模式
 * 将构造方法进行改造，如果实例已经创建，则抛出异常。但对于懒汉式的单实例，如果反射调用构造方法在提供的方法之前，将导致通过提供的方法获取实例失败。
 *
 * @author stewart
 */
public class SingletonExt02 implements Serializable {

    private static final SingletonExt02 INSTANCE = new SingletonExt02();

    private static boolean flag;

    private SingletonExt02() {
        synchronized (SingletonExt02.class) {
            if (flag) {
                throw new RuntimeException("单例实例不能被重复创建");
            }
            flag = true;
        }
    }

    public static SingletonExt02 getInstance() {
//        if (instance == null) {
//            synchronized (SingletonExt02.class) {
//                if (instance == null) {
//                    instance = new SingletonExt02();
//                }
//            }
//        }
        return INSTANCE;
    }

}
