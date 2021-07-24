package com.stewart.patterns.creational.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author stewart
 */
public class SingletonTest001 {

    private static void writeObject2File() throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("SingletonObject.txt"));
        output.writeObject(SingletonDemo04.getInstance());
        output.close();
    }

    private static Object readObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("SingletonObject.txt"));
        SingletonDemo04 object = (SingletonDemo04) input.readObject();
        input.close();
        return object;
    }

    private static void writeExtObject2File() throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("SingletonObjectExt.txt"));
        output.writeObject(SingletonExt01.getInstance());
    }

    private static Object readExtObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("SingletonObjectExt.txt"));
        SingletonExt01 object = (SingletonExt01) input.readObject();
        return object;
    }

    @Test
    public void test001() {
        Assert.assertSame(SingletonDemo01.getInstance(), SingletonDemo01.getInstance());
    }

    @Test
    public void test002() {
        Assert.assertSame(SingletonDemo02.getInstance(), SingletonDemo02.getInstance());
    }

    @Test
    public void test003() {
        Assert.assertSame(SingletonDemo03.getInstance(), SingletonDemo03.getInstance());
    }

    @Test
    public void test004() {
        Assert.assertSame(SingletonDemo04.getInstance(), SingletonDemo04.getInstance());
    }

    @Test
    public void test005() {
        Assert.assertSame(SingletonDemo05.getInstance(), SingletonDemo05.getInstance());
    }

    @Test
    public void test006() {
        Assert.assertSame(SingletonDemo06.INSTANCE, SingletonDemo06.INSTANCE);
    }

    /**
     * 序列化、反序列化破坏单例及解决方案
     */
    @Test
    public void test007() throws Exception {
        Assert.assertSame(SingletonDemo04.getInstance(), SingletonDemo04.getInstance());
        writeObject2File();
        Object object = readObjectFromFile();
        Assert.assertNotSame(SingletonDemo04.getInstance(), object);

        Assert.assertSame(SingletonExt01.getInstance(), SingletonExt01.getInstance());
        writeExtObject2File();
        Object extObject = readExtObjectFromFile();
        Assert.assertSame(SingletonExt01.getInstance(), extObject);
        Assert.assertSame(readExtObjectFromFile(), extObject);
    }

    /**
     * 反射破坏单例及解决方案
     */
    @Test
    public void test008() throws Exception {
        Class<SingletonDemo04> demo04Class = SingletonDemo04.class;
        Constructor<SingletonDemo04> demo04Constructor = demo04Class.getDeclaredConstructor();
        demo04Constructor.setAccessible(true);
        SingletonDemo04 singletonDemo04 = demo04Constructor.newInstance();
        Assert.assertNotSame(singletonDemo04, SingletonDemo04.getInstance());

        Class<SingletonExt02> ext02Class = SingletonExt02.class;
        Constructor<SingletonExt02> ext02Constructor = ext02Class.getDeclaredConstructor();
        ext02Constructor.setAccessible(true);
        //抛出RuntimeException，导致反射实例化失败，最终实际抛出为InvocationException
        Assert.assertThrows(InvocationTargetException.class, ext02Constructor::newInstance);
    }

}
