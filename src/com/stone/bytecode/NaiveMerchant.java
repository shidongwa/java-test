package com.stone.bytecode;

/**
 * @Author: shidonghua
 * @Description: 参考：https://blog.csdn.net/jiaobuchong/article/details/83722193
 * javap -v -c production/classes/com/stone/bytecode/NaiveMerchant.class可以看到桥接方法actionPrice
 * @Date: 10/23/20 08:49
 * @Version: 1.0
 */
public class NaiveMerchant extends Merchant {
    @Override
    public Double actionPrice(double price) {
        return 0.9 * price;
    }

    public static void main(String[] args) {
        Merchant merchant = new NaiveMerchant();
        // price 必须定义成 Number 类型
        Number price = merchant.actionPrice(40);
        System.out.println(price);
    }
}