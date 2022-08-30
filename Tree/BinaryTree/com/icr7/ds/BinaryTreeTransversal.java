package com.icr7.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTransversal {
    public static void main(String[] args) {
        Tree1 tree = new Tree1();
        for (int i = 1; i < 17; i++) {
            tree.add(i);
        }
        System.out.println("inorder : "+tree.getInOrder());
        System.out.println("preorder : "+tree.getPreOrder());
        System.out.println("postorder : "+tree.getPostOrder());
    }
}

class Tree1 {
    Node root;
    int addCount;


    Queue<Node> queue = new LinkedList<>();

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            queue.add(root);
        } else {
            if (queue.peek().left == null) {
                queue.peek().left = new Node(data);
                queue.add(queue.peek().left);
            } else if (queue.peek().right == null) {
                queue.peek().right = new Node(data);
                queue.add(queue.peek().right);
            }
            addCount++;
            if (addCount == 2) {
                queue.poll();
                addCount = 0;
            }
        }
    }


    public List<Integer> getInOrder() {
        List<Integer> list = new ArrayList<>();
        getInOrder(this.root, list);
        return list;
    }

    private void getInOrder(Node root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    public List<Integer> getPreOrder() {
        List<Integer> list = new ArrayList<>();
        getPreOrder(this.root, list);
        return list;
    }

    private void getPreOrder(Node root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        list.add(root.data);
        getPreOrder(root.left, list);
        getPreOrder(root.right, list);
    }

    public List<Integer> getPostOrder() {
        List<Integer> list = new ArrayList<>();
        getPostOrder(this.root, list);
        return list;
    }

    private void getPostOrder(Node root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        getPostOrder(root.left, list);
        getPostOrder(root.right, list);
        list.add(root.data);
    }
}