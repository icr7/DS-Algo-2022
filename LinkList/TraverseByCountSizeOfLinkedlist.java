package com.icr7.leetcode.linkedlist;

import java.util.Scanner;

public class TraverseByCountSizeOfLinkedlist {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 LinkedList list= new LinkedList();
	 int n;
	 do {
		 n=sc.nextInt();
		 list.push(n);
		 
	 }while(n!=0);//exit on inserting 0, but also include on list
		
	 System.out.println("Size of List : "+ list.size());
	}
}

class LinkedList {

	class Node {
		int data;
		Node nextNode;
		Node(int data) { this.data = data;}
	}

	Node head = null;
	Node tail = null;

	public void push(int data) {
		
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			tail.nextNode = newNode;
			tail = tail.nextNode;
		}
	}
	
	public int size() {
		Node currentNode = head;
		int count=0;
		while(currentNode!=null) {
			currentNode=currentNode.nextNode;
			count++;
		}
		return count;
	}
}
