package com.stone.hotswap2;

/**
 * 测试Java类的热加载
 * @author wy
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
