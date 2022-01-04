package com.icr7.leetcode.linkedlist;

public class FillingLinkedList {

	public static void main(String[] args) {
		LinkedList myList[] = new LinkedList[5];
		
		for (int i = 0; i < 5; i++) {
			myList[i] = new LinkedList();
			
			myList[i].setData((i + 1) * 5);
			if (i == 4) {
				myList[i].setNext(null);
			} else {
				myList[i + 1] = new LinkedList();
				myList[i].setNext(myList[i + 1]);
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(myList[i].getData());
		}

	}

}

class LinkedList {
	int data;
	LinkedList nextLinkedList;

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(LinkedList next) {
		this.nextLinkedList = next;
	}

	public int getData() {
		return this.data;
	}

	public LinkedList getNext() {
		return this.nextLinkedList;
	}
}