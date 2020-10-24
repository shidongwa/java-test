package com.stone.bytecode;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 10/24/20 17:24
 * @Version: 1.0
 */
public class VipShop extends Shop<VipCustomer> {
    @Override
    double purchase(double price, VipCustomer customer) {
        return price * customer.rate();
    }
}
