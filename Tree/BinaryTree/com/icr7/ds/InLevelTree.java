package com.icr7.ds;

import java.util.ArrayList;
import java.util.HashMap;

public class InLevelTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        for (int i = 1; i < 10; i++) {
            tree.add(i);
        }
        System.out.println(tree.root);
        tree.printInlevel();
        tree.add(10);
        System.out.println();
        System.out.println("----------- After adding 10 in tree ----------");
        tree.printInlevel();
        System.out.println("\n----------- get LevelOrder Using Map----------");
        System.out.println(tree.getLevelOrderUsingMap());
    }


}

class Tree {
    public TreeNode root;
    public int level;
    private Boolean inserted;
    private int count;

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode() {
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode insertIntree(TreeNode root, int data, int level) {

        if (root == null) {
            root = new TreeNode(data);
            this.inserted = true;
        } else if (level == 1 && root != null) {
            return root;
        } else {

            if (!inserted) {
                root.left = insertIntree(root.left, data, level - 1);
            }

            if (!inserted) {
                root.right = insertIntree(root.right, data, level - 1);
            }

        }
        return root;
    }

    public void add(int data) {
        count++;
        level = (int) (Math.log(count) / Math.log(2)) + 1;
        inserted = false;
        root = this.insertIntree(root, data, level);

    }

    public void printInlevel() {
        for (int i = 1; i <= level; i++) {
            System.out.println();
            System.out.print("-------level-------->" + i);
            System.out.println();
            printTree(i, root);
        }
    }

    public void printTree(int level, TreeNode root) {
        if (root == null) {
            //donothing
        } else if (level == 1) {
            System.out.print(root.data + ", ");
        } else {
            printTree(level - 1, root.left);
            printTree(level - 1, root.right);
        }
    }

    public HashMap<Integer, ArrayList<Integer>> getLevelOrderUsingMap() {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        getLevelOrderUsingMap(this.root, map, 0);
        return map;
    }


    public void getLevelOrderUsingMap(TreeNode root, HashMap<Integer, ArrayList<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        if (map.get(level) == null) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.data);

        getLevelOrderUsingMap(root.left, map, level + 1);
        getLevelOrderUsingMap(root.right, map, level + 1);

    }
}