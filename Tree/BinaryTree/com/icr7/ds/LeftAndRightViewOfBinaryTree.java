package com.icr7.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeftAndRightViewOfBinaryTree {
    public static void main(String[] args) {
        Tree6 tree = new Tree6();
        for(int i=1;i<16;i++){
            tree.insertInLevel(i);
        }
        System.out.println("left view : "+tree.getLeftView());
        System.out.println("right view : "+tree.getRightView());
    }
}
class Tree6{
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

    public HashMap<Integer,Integer> getLeftView(){
        HashMap<Integer,Integer> leftMap = new HashMap<>();
        getLeftView(this.root, leftMap, 0);
        return  leftMap;
    }

    private void getLeftView(Node root, HashMap leftMap, int level) {
        if(root==null){
            return;
        }
        if(leftMap.get(level)==null){
            leftMap.put(level, root.data);
        }
        getLeftView(root.left, leftMap, level+1);
        getLeftView(root.right, leftMap, level+1);
    }

    public HashMap<Integer,Integer> getRightView(){
        HashMap<Integer,Integer> rightMap = new HashMap<>();
        getRightView(this.root, rightMap, 0);
        return  rightMap;
    }

    private void getRightView(Node root, HashMap<Integer, Integer> rightMap, int level) {
        if(root==null){
            return;
        }
        if(rightMap.get(level)==null){
            rightMap.put(level, root.data);
        }
        getRightView(root.right, rightMap, level+1);
        getRightView(root.left, rightMap, level+1);
    }
}