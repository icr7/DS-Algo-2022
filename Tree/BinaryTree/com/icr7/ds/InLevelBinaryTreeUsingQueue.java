package com.icr7.ds;

import java.util.LinkedList;
import java.util.Queue;

public class InLevelBinaryTreeUsingQueue {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();
        for(int i=1;i<16;i++){
            tree.insertInLevel(i);
        }
        tree.printInLevel();
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

    Queue<Node> printQ ;
    public void printInLevel(){
         printQ=new LinkedList<>();
         printQ();
    }
    public void printQ() {
        printQ.add(root);
        while (printQ.size() != 0) {
            if(printQ.peek().left!=null){
                printQ.add(printQ.peek().left);
            }
            if(printQ.peek().right!=null){
                printQ.add(printQ.peek().right);
            }
            System.out.print(printQ.peek().data+", ");
            printQ.poll();

        }

    }
}