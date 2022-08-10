package com.icr7.ds;

import java.util.*;

public class TopAndBottomViewOfBinaryTree {
    public static void main(String[] args) {
        Tree7  tree = new Tree7();
        for (int i=1;i<=10;i++)
        tree.add(i);

        System.out.println(tree.getTopView());
    }
}
class Tree7{
    Node root;
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data= data;
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
    public void add(int data){
        if(this.root==null){
            root= new Node(data);
            queue.add(root);
        }
        else {
            if (queue.peek().left == null) {
                queue.peek().left = new Node(data);
                queue.add(queue.peek().left);
            } else if (queue.peek().right == null) {
                queue.peek().right = new Node(data);
                queue.add(queue.peek().right);
                queue.poll();
            }
        }
    }

    public HashMap<Integer,ArrayList> levelOrder(){
        HashMap<Integer,ArrayList> levelOrderMap = new HashMap<>();
        levelOrder(root,levelOrderMap,0);
        return levelOrderMap;
    }

    private void levelOrder(Node root, HashMap<Integer,ArrayList> map, int level) {
        if(root==null){
            return;
        }
        if(map.get(level)==null){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.data);
        levelOrder(root.left, map, level+1);
        levelOrder(root.right, map, level+1);
    }

    public HashMap getTopView(){
        HashMap<Integer,Integer> map = new HashMap<>();
        getTopView(root,map,0, 0);
        return map;
    }
    public void getTopView(Node root, HashMap<Integer, Integer> map,Integer level, Integer far){
        if (root == null) {
            return;
        }
        if(map.get(far)==null){
            map.put(far,root.data);
        }
        getTopView(root.left,map,level+1, far-1);
        getTopView(root.right,map,level+1, far+1);
    }
}
