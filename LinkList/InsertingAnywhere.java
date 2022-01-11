package com.icr7.leetcode.linkedlist;

import java.util.Scanner;

public class InsertingAnywhere {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int n;
		System.out.println("push data");
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			} else {
				list.push(n);
			}
		}

		System.out.println("before inserting element");
		list.display();
		list.push(9, sc.nextInt());
		System.out.println("\nafter inserting element");
		list.display();

	}// main

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

	public void push(int data, int pos) {
		Node newNode = new Node(data);
		Node currentNode = head;
		for (int i = 0; i < pos - 1; i++) {
			currentNode = currentNode.nextNode;
		}
		newNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = newNode;
	}

	public void display() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
	}
}
