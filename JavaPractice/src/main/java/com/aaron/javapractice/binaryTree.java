package com.aaron.javapractice;

import java.util.LinkedList;
import java.util.Queue;

public class binaryTree {
    private final String inputStr0 = "1-2--3--4-5--6--7";
    private final String inputStr1 = "1-2--3---4-5--6---7";
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode recoverFromPreorder(String S) {
        TreeNode root = new TreeNode(S.charAt(0));
        int deep = 0,index = 0;
        while (S.charAt(index) == '-') {
            index ++;
            deep ++;
        }
        return  root;
    }

    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.recoverFromPreorder(bt.inputStr0);
    }
}
