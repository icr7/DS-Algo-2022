
package com.icr7.ds;

        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Queue;

public class MaximumElementInTree {
    public static void main(String[] args) {
        Tree4 tree = new Tree4();
        for(int i=1;i<16;i++){
            tree.insertInLevel(i);
        }
        System.out.println("maximum element is : "+tree.max());
    }
}
class Tree4{
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

    public int max(){
        return max(root);
    }
    public int max(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max
                (Math.max(max(root.left),max(root.right))
                        , root.data);
    }

}