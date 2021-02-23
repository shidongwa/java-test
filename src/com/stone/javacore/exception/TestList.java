package com.stone.javacore.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 2021/2/1 上午8:34
 * @Version: 1.0
 */
public class TestList {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");

        for(String item : l) {
            if("2".equals(item)) { // ConcurrentModificationException
                l.remove(item);
            }
        }

        System.out.println("list:" + l);
    }
}
