package com.stone.java_concurrency_in_practice.chapter5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {  
	  
    public static void main(String[] args) {  
      
        ExecutorService exec = Executors.newCachedThreadPool();       
        final Random random=new Random();  
          
        final CyclicBarrier barrier=new CyclicBarrier(4,new Runnable(){  
            @Override  
            public void run() {  
                System.out.println("all ready.");  
            }});  
          
        for(int i=0;i<4;i++){  
            exec.execute(new Runnable(){  
                @Override  
                public void run() {  
                    try {  
                        Thread.sleep(random.nextInt(1000));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    System.out.println(Thread.currentThread().getName()+" wait for others");  
                    try {  
                        barrier.await();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    } catch (BrokenBarrierException e) {  
                        e.printStackTrace();  
                    }  
                }});  
        }  
        exec.shutdown();  
    }  
  
}  
