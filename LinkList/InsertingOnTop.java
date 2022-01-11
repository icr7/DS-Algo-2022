package com.icr7.leetcode.linkedlist;

import java.util.Scanner;

public class InsertingOnTop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		LinkedList list = new LinkedList();
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			list.push(n);
		}
		
		System.out.println("before inserting element");
		list.display();
		System.out.println("\ninsert elements to top");

		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			} else
				list.pushTop(n);
		}
		System.out.println("after inserting element to top");
		list.display();
	}

}
class LinkedList{
	class Node{
		int data;
		Node nextNode;
	    Node(int data){this.data=data;}
	}
	
	Node head = null;
	Node tail = null;
	
	public void push(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.nextNode=newNode;
			tail= tail.nextNode;
		}
	}
	
	public void pushTop(int data) {
		Node newNode= new Node(data);
		newNode.nextNode=head;
		head=newNode;
	}
	
	public void display() {
		Node currentNode=head;
		while(currentNode!=null) {
			System.out.print(currentNode.data+" ");
			currentNode=currentNode.nextNode;
		}
	}
	
}
