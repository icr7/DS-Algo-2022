package com.icr7.leetcode.linkedlist;

import java.util.Scanner;

public class FillingLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList myList = new LinkedList();
		LinkedList head = myList;
		LinkedList tail = myList;

		
		for(int i=1;i<101;i++) {
			tail.push(i*2);
			tail=tail.getNext();
			
		}

		for(int i=1;i<101;i++) {
			System.out.println(head.getData());
			head=head.getNext();
		}
		
	}

}

class LinkedList {
	private int data;
	private LinkedList nextLinkedList;
	int headcount=0;
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
		return nextLinkedList;
	}
	
	public void push(int data) {
		LinkedList newList=new LinkedList();
		if(headcount==0) {
			this.data=data;
			this.nextLinkedList=newList;
			
		}
		else {
		
		newList.setData(data);
		this.nextLinkedList=newList;
		headcount++;
		}
	}
		
}