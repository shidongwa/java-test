package com.stone.hotswap2;

/**
 * BaseManager接口是实现类，此类需要实现Java类的热加载功能
 * @author wy
 */
public class MyManager implements BaseManager {
    @Override
    public void logic() {
        System.out.println("Java类热加载！TEST2");
        System.out.println("Java类");
    }
}
