package com.stone.train;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 6/30/20 15:30
 * @Version: 1.0
 */
public class Test4 {
    /**
    Given one array like int arr[]= { 20, 9, 10,  25, 16, 2, 40} ,  build binary search tree for them , and search nodes in a range .
            for example the range is [9, 15],  9, 10 should be print or return.
     */

    public static void main(String[] args) {
        int[] arr = new int[] {20, 9, 10,  25, 16, 2, 40};
        // 暂不考虑边界条件
        BinaryTree root = new BinaryTree(arr[0]);

        // 重建二叉树
        for(int i = 1; i < arr.length; i++) {
            root.addNode(arr[i]);
        }

        int left = 9, right = 15;
        List<Integer> ans = new ArrayList<>();
        // 先序遍历并查找
        root.preSearch(root.root, left, right, ans);

        System.out.println("ans:" + ans);
    }


    static class BinaryTree {
        private TreeNode root;

        public BinaryTree(int val) {
            root = new TreeNode(val);
        }

        /**
         * 增加节点
         * @param val
         */
        public void addNode(int val) {
            TreeNode treeNode = root;
            TreeNode pre = null;
            while(treeNode != null) {
                pre = treeNode;
                if(val < treeNode.val) {
                    treeNode = treeNode.left;
                } else {
                    treeNode = treeNode.right;
                }
            }

            if(pre != null) {
                if(val > pre.val) {
                    pre.right = new TreeNode(val);
                } else {
                    pre.left = new TreeNode(val);
                }
            }
        }

        public TreeNode getRoot() {
            return root;
        }

        /**
         * 先序遍历
         * @param root
         * @param left
         * @param right
         * @param ans
         */
        public void preSearch(TreeNode root, int left, int right, List<Integer> ans) {
            // 递归结束条件
            if(root == null) {
                return;
            }

            preSearch(root.left, left, right, ans);
            if(root.val >= left && root.val <= right) {
                ans.add(root.val);
            }
            preSearch(root.right, left, right, ans);
        }

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
