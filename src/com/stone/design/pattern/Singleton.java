package com.stone.design.pattern;

/**
 * @Author: shidonghua
 * @Description:
 * 类的初始化何时会被触发呢？JVM 规范枚举了下述多种触发情况：
 * 当虚拟机启动时，初始化用户指定的主类；
 * 当遇到用以新建目标类实例的 new 指令时，初始化 new 指令的目标类；
 * 当遇到调用静态方法的指令时，初始化该静态方法所在的类；
 * 当遇到访问静态字段的指令时，初始化该静态字段所在的类；
 * 子类的初始化会触发父类的初始化；
 * 如果一个接口定义了 default 方法，那么直接实现或者间接实现该接口的类的初始化，会触发该接口的初始化；
 * 使用反射 API 对某个类进行反射调用时，初始化这个类；
 * 当初次调用 MethodHandle 实例时，初始化该 MethodHandle 指向的方法所在的类。
 * @Date: 12/12/20 07:39
 * @Version: 1.0
 */
public class Singleton {
    private Singleton() {}

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
