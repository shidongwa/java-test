package com.stone.generic;

import java.util.List;

public class GenericOverload {

    /**
     * 泛型类型不同不能通过编译，和下面的方法冲突
     * @param arg2
     */
    /*
    public void method1(List<Integer> arg1) {

    }
     */

    public void method1(List<String> arg2) {

    }
}
