package com.icr7.ds;

import java.util.LinkedList;
import java.util.Queue;

public class MaxMinHeightofBinaryTree {
    public static void main(String[] args) {
        Tree3 tree = new Tree3();
        for(int i=1;i<10;i++){
            tree.insertInLevel(i);
        }
        System.out.println("----max-height----- "+ tree.maxHeight());
        System.out.println("----min-height----- "+ tree.minHeight());
    }
}
class Tree3{
    Node root;
    Queue<Node> queue = new LinkedList<>();
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    public void insertInLevel(int data){
        if(root==null){
            root= new Node(data);
            queue.add(root);
        }else{
            Node tempRoot= new Node(data);
            queue.add(tempRoot);
            if(queue.peek().left==null){
                queue.peek().left=tempRoot;
            } else if (queue.peek().right==null) {
                queue.peek().right=tempRoot;
                queue.poll();
            }
        }
    }

    public int maxHeight(){
        return max(this.root);
    }

    public int minHeight(){
        return min(this.root);
    }
    public int max(Node root){
        if(root==null){
            return 0;
        }else{
            return Math.max(max(root.left),max(root.right))+1;
        }
    }

    public int min(Node root){
        if(root==null){
            return 0;
        }else{
            return Math.min(min(root.left),min(root.right))+1;
        }
    }
}