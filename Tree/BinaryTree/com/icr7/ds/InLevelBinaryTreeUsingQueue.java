package com.icr7.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InLevelBinaryTreeUsingQueue {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();
        for(int i=1;i<16;i++){
            tree.insertInLevel(i);
        }
        System.out.println(tree.printInLevel());
    }
}
class Tree2{
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

    public List<Integer> printInLevel(){
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.data);
        while(queue.size()!=0){
            if(queue.peek().left!=null){
                queue.add(queue.peek().left);
            }
            if(queue.peek().right!=null){
                queue.add(queue.peek().right);
            }
            list.add(queue.peek().data);
            queue.poll();
        }
       return list;
    }
}