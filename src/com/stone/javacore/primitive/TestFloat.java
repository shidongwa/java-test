package com.stone.javacore.primitive;

public class TestFloat {

    public static void main(String[] args) {
        // 3.4是双精度，赋值给浮点数会造成精度丢失，需要强转或者后面加f
        //float f = 3.4; // 异常
        float f1 = 3.4f;
        float f2 = (float)3.4;

        double d = 3.4;
    }
}
