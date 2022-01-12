package com.icr7.leetcode.linkedlist;

public class DeleteFirstNode {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		System.out.print("list before deletion: ");
		list.display();
		int i = 1;
		while(list.getNextNode()!=null) {
			list.deleteTop();
			System.out.print("\nlist after "+i+" Top deletion: ");
			list.display();
			i++;
		}

	}

}

class LinkedList {
	class Node {
		int data;
		Node nextNode;

		Node(int data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	public Node getNextNode()
	{
		return head.nextNode;
	}

	Node head = null;
	Node tail = null;

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.nextNode = newNode;
			tail = tail.nextNode;
		}
	}
	public void display() {
		Node currentNode = head;
		
		while(currentNode!=null) {
			System.out.print(currentNode.data+" ");
			currentNode=currentNode.nextNode;
		}
		
	}
	public  void deleteTop() {
		Node currentNode=head;
		head=currentNode.nextNode;
		currentNode=null;
	}
}
