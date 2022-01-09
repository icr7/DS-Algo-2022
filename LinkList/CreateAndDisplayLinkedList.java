package com.icr7.leetcode.linkedlist;

public class CreateAndDisplayLinkedList {

	public static void main(String[] args) {
		LinkedList myList=new LinkedList();
		myList.push(1);
		myList.push(2);
		myList.push(3);
		myList.push(4);
		myList.push(5);
		myList.push(6);
		myList.push(7);
		myList.display();

	}

}
class LinkedList{
	
	class Node{
		public int data;
		public Node next;
		
		Node(int data){
			this.data = data;
			this.next=null;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	
	public void push(int data) {
		Node newNode= new Node(data);
	
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=tail.next;
		}		
	}
	
	public void display() {
		Node curr= head;
		while(curr!=null) {
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	
}
