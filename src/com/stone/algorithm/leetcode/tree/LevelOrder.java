package com.stone.algorithm.leetcode.tree;

import java.util.*;

/**
 *
 *  @author    shidonghua
 *  @date      6/25/20 11:00
 *  @version   1.0
 */
public class LevelOrder {

    public static void main(String[] args) {
        LevelOrder lo = new LevelOrder();
        TreeNode root = lo.buildTree();
        List<List<Integer>> l = lo.levelOrder(root);

        //l.stream().forEach(System.out::println);
        System.out.println("l = " + l);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();

        if(root == null) {
            return ans;
        }

        q1.offerLast(root);
        int level = 1;
        q2.addLast(level);
        List<Integer> row = new ArrayList<>();
        while(!q1.isEmpty()) {
            TreeNode n = q1.pollFirst();
            int l = q2.pollFirst();

            if(l != level) {
                ans.add(row);
                row = new ArrayList<>();
                row.add(n.val);
                level = l;
            } else {
                row.add(n.val);
            }

            if(n.left != null) {
                q1.offerLast(n.left);
                q2.offerLast(l+1);
            }
            if(n.right != null) {
                q1.offerLast(n.right);
                q2.offerLast(l+1);
            }
        }

        if(!row.isEmpty()) {
            ans.add(row);
        }

        return ans;
    }

    private TreeNode buildTree() {
        TreeNode n = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n.left = n2;
        n.right = n3;
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n3.left = n4;
        n3.right = n5;

        return n;
    }

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
}
