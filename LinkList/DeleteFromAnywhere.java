import java.util.Scanner;

public class DeleteFromAnywhere{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        linkedList list=new linkedList();
        for(int i=0;i<5;i++){
            list.push(i+1);
        }
        System.out.println("before delete element: ");
        list.display();
        System.out.println("which postion want to remove");
        int pos=sc.nextInt();
        if(pos<0||pos>5){
            System.out.println("invalid position");
        }
        else{
            list.delete(pos);
            System.out.println("\nafter delete element: ");
            list.display();
        }

    }
}
class linkedList{
    class Node{
        int data;
        Node nextNode;
        Node(int data){
            this.data=data;
            this.nextNode=null;
        }
    }

    Node head=null;
    Node tail=null;
    public void push(int data){
        Node newNode=new Node(data);
         if(head==null){
            head=newNode;
            tail=newNode;
        }else {
             tail.nextNode=newNode;
             tail=tail.nextNode;
        }
    }

    public void display(){
         Node currentNode=head;
         while(currentNode!=null){
            System.out.println(currentNode.data+" ");
            currentNode=currentNode.nextNode;
        }
    }

    public void deleteFirstElement(){
         Node currentNode=head;
         head=head.nextNode;
         currentNode.nextNode=null;
    }

     public void delete(int pos){
         if(pos==1){
             deleteFirstElement();
            }
         else{
            Node currentNode=head;
            for(int i=2;i<pos;i++){
                currentNode=currentNode.nextNode;
             }
             Node temp=currentNode.nextNode;
             currentNode.nextNode=temp.nextNode;
             temp.nextNode=null;
            }
    }

    
}