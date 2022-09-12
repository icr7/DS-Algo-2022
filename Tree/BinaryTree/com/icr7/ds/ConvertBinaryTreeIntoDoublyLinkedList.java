package com.icr7.ds;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBinaryTreeIntoDoublyLinkedList {
    public static void main(String[] args) {
        Tree8 tree = new Tree8();
        for (int i=1;i<=7;i++){
            tree.add(i);
        }tree.convertToDll();
        tree.printDll(tree.head);
    }

}

class Tree8{
    Node root;

    Queue<Node> queue = new LinkedList<>();
    int flag=0;
    class Node{
        int data;
        Node left;
        Node right;
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

    public void add(int data){
        if(root==null){
            root=new Node(data);
            queue.add(root);
        }
        else{
            if(queue.peek().left==null){
                queue.peek().left=new Node(data);
                queue.add(queue.peek().left);
            }
            else if(queue.peek().right==null){
                queue.peek().right=new Node(data);
                queue.add(queue.peek().right);
            }
            flag++;
            if(flag==2){
                queue.poll();
                flag=0;
            }
        }
    }
    Node head = null, prev = null;
    public Node convertToDll(){

        convertToDll(this.root);
        return head;
    }

    private void convertToDll(Node root) {
        if(root==null){
            return;
        }
        convertToDll(root.left);
        if(prev==null) head=root;
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertToDll(root.right);
    }

    void printDll(Node node){
        while(node != null){
            System.out.print(node.data+" ");
            node=node.right;
        }
    }
}