package com.icr7.ds;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        Tree5 tree = new Tree5();
        for(int i=1;i<16;i++){
            tree.insertInLevel(i);
        }
        System.out.println("size of binary tree is : "+tree.size());
    }
}
class Tree5{
    Node root;
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

    Queue<Node> queue = new LinkedList<>();
    public void insertInLevel(int data){
        if(root==null){
            root= new Node(data);
            queue.add(root);
        }else{
            if(queue.peek().left==null){
                queue.peek().left=new Node(data);
                queue.add(queue.peek().left);
            }
            else if(queue.peek().right==null){
                queue.peek().right=new Node(data);
                queue.add(queue.peek().right);
                queue.poll();
            }
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node root){
        if(root==null){
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }
}