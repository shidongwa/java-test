package com.stone.javacore;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by shidonghua on 2017/4/2.
 *
 * test hashmap high cpu issue in multi-thread case
 *
 * test in macbook pro, no 100% cpu occur actually
 */
public class TestHashMap {

    public  static void  main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }
