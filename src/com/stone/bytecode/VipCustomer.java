package com.stone.bytecode;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 10/24/20 17:17
 * @Version: 1.0
 */
public class VipCustomer implements Customer {
    @Override
    public double rate() {
        return 0.8;
    }
}
