package com.stone.thread;

/**
 * demo show the difference between user and daemon threads
 * Created by shidonghua on 2017/8/23.
 */
public class TestDaemonThread {


    public static void main(String[] args) {

        Runnable r1 = new TestDaemonThread().new Thread1();
        Thread t1 = new Thread(r1);
        // user thread completes after main thread
        t1.start();

        // daemon thread complete immediately when main thread completes
//        t1.setDaemon(true);
//        t1.start();


        System.out.println(Thread.currentThread().getName() + " completes");
    }

    public class Thread1 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " completes");
        }
    }
}
