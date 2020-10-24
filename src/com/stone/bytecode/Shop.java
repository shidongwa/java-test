package com.stone.bytecode;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 10/24/20 17:22
 * @Version: 1.0
 */
abstract public class Shop<T extends Customer> {
    abstract double purchase(double price, T customer);
}
