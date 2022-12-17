package com.stone.javacore;

public class ValueOrRefInvoke {

    /**
     * 1，java对象传递的也是引用（对象地址）。形参中虽然值进行了交换，但是实参中对象地址还是没有变化
     *
     * 2，对象地址是值传递，可以在调用方法中修改对象中字段属性，因为指向的是同一个对象
     * @param args
     */
    public static void main(String[] args) {
        // 实参中的对象地址值不会交换
        Person p1 = new Person("xiaoming");
        Person p2 = new Person("xiaolan");
        System.out.println("[before] p1:" + p1);
        System.out.println("[before] p2:" + p2);
        swap(p1, p2);
        System.out.println("[after] p1:" + p1);
        System.out.println("[after] p2:" + p2);

        // 方法调用中可以改变对象内容
        change(p1);
        System.out.println("[after change] p1:" + p1);
    }

    public static void swap(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public static void change(Person p1) {
        p1.setName("changed xiaoming");
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
