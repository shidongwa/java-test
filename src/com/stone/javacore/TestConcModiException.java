package com.stone.javacore;

import org.junit.Test;
import org.testng.annotations.ExpectedExceptions;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shidonghua on 2017/4/4.
 */
public class TestConcModiException {

    /**
     * will not throw ConcurrentModificationException
     *
     * 原因分析：
     *
     *  public boolean hasNext() {
     *      return cursor != size;
     * }
     * 我们以上面的代码为例，当删除倒数第二个数据也就是”1”的时候，cursor是1,然后调用删除操作，此时size由2变成了1，
     * 当再调用hasNext判断的时候，cursor==size,就会调用后面的操作直接退出循环了。
     */
    @Test
    public void test1() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }

        System.out.println(a);
    }

    /**
     * will throw ConcurrentModificationExceptio
     */
    @Test(expected=ConcurrentModificationException.class)
    public void test2() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }

        System.out.println(a);
    }

    /**
     * iterator remove will not throw ConcurrentModificationExceptio
     */
    @Test
    public void test3() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");

        Iterator<String> it = a.iterator();
        while(it.hasNext()){
            String x = it.next();
            if(x.equals("2")){
                it.remove();
            }
        }

        System.out.println(a);
    }
}
