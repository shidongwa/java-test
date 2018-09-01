package com.stone.javacore;

public class PrivateAccess {
    public static class Line{
        private double k;
        private double b;
        private boolean isVertical;

        public Line(double k, double b, boolean isVertical){
            this.k = k;
            this.b = b;
            this.isVertical = isVertical;
        }

    }

    public static  void main (String[] args){
        System.out.println(new Line(1, 2,false).k);
    }
}