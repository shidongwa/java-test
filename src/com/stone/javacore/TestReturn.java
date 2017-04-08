package com.stone.javacore;

import org.junit.Test;

/**
 * Created by shidonghua on 2017/4/4.
 */
public class TestReturn {

    /**
     * 不能在 finally 块中使用 return，finally 块中的 return 返回后方法结束执行，不
     * 会再执行 try 块中的 return 语句
     */
    @Test
    public void testReturn(){
        System.out.println("call return:" + call());
    }

    public String call() {
        try {
            System.out.println("step1");

            //throw new RuntimeException("My Exception");
            return "return in try";
        } catch (Exception ex) {
            System.out.println("in Exception");
        } finally {
            System.out.println("step2");
            return "return in finally";
        }
    }
}
