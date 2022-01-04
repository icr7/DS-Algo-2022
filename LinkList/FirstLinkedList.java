package com.icr7.leetcode.linkedlist;

public class FirstLinkedList {

	public static void main(String[] args) {
		LinkedList list1=new LinkedList();
		list1.setLinkedList(1);
		LinkedList list2=new LinkedList();
		list2.setLinkedList(2);
		list1.setNextLinkedList(list2);
		LinkedList list3=new LinkedList();
		list3.setLinkedList(3);
		list2.setNextLinkedList(list3);
		
		System.out.println(list1.getData());
		System.out.println(list1.getNext().getData());
		System.out.println(list1.getNext().getNext().getData());

	}

}
class LinkedList{
	int data;
	LinkedList nextLinkedList;
	
	public void setLinkedList(int data) {
		this.data=data;
	}
	public void setNextLinkedList(LinkedList next) {
		this.nextLinkedList=next;
	}
	public int getData() {
		return this.data;
	}
	
	public LinkedList getNext() {
		return this.nextLinkedList;
	}
}