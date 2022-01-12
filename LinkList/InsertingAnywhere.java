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
			if (n == 0) { // push element until enter 0
				break;
			} else {
				list.push(n);
			}
		}

		System.out.println("Before inserting element");
		list.display();
		System.out.println("Size: " + list.size());

		System.out.print("Enter element you want to push: ");
		int element = sc.nextInt();

		System.out.print("Enter postion where you want to push: ");
		int pos = sc.nextInt();

		if (pos > 0 && pos <= list.size() + 1) {
			list.push(element, pos);
			System.out.println("After inserting element");
			list.display();
			System.out.println("Size: " + list.size());
		} else {
			System.out.println("Invaild position");
		}

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
	int size = 0;

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.nextNode = newNode;
			tail = tail.nextNode;
			size++;
		}
	}

	public void push(int data, int pos) {
		Node newNode = new Node(data);
		Node currentNode = head;
		if (pos == 1) {
			pushAtTop(newNode);
		} else {
			for (int i = 1; i < pos - 1; i++) {
				currentNode = currentNode.nextNode;
			}
			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = newNode;
			size++;
		}
	}

	public void pushAtTop(Node node) {
		node.nextNode = head;
		head = node;
		size++;
	}

	public void display() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
	}

	public int size() {
		return this.size;
	}
}
