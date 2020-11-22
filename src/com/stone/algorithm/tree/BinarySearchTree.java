package com.stone.algorithm.tree;

/**
 * @Author: shidonghua
 * @Description: 这里二叉搜索树实现不是重点，重点是Node类的定义为静态内部类。可以在算法类中直接访问静态内部类的private属性。
 * 避免getter方法或者public字段的声明
 * @Date: 11/22/20 11:01
 * @Version: 1.0
 */

public class BinarySearchTree {
    private Node root;

    public Node find(int data) {
        Node p = root;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }

        return null;
    }

    public BinarySearchTree() {
        root = new Node(8);
        root.left = new Node(3, new Node(1), new Node(4));
        root.right = new Node(15, new Node(11), new Node(17));
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node n = tree.find(15);

        System.out.println("n:" + n.data);
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
