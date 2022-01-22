public class StackWithLinkedList {
    public static void main(String[] args) {
        Stack list = new Stack();
        for (int i = 1; i < 6; i++) {
            System.out.print("\nis empty : "+list.isEmpty());
            System.out.println("\npeek() --->" + list.peek());
            list.push(i);
            System.out.print("After pushing " + i + " element -->");
            list.display();
            System.out.println();
        }

        System.out.println();
        for (int i = 1; i < 6; i++) {
            list.pop();
            System.out.print("\nAfter poping " + i + " element -->");
            list.display();
            System.out.print("\npeek() --->" + list.peek());
            System.out.print("\nis empty : "+list.isEmpty());
            System.out.println();
        }
    }
}

class Stack {
    class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            top.next = newNode;
            top.next.prev = top;
            top = top.next;
        }
    }

    public void pop() {
        Node curr = top;
        if (top == null) {
            System.out.println("empty list");
        } else {
            top = top.prev;
            curr = null;
        }
    }

    public int peek() {
        if (top == null) {
            return -1;
        } else
            return top.data;
    }

    public String isEmpty() {
        if (top == null)
            return "empty";
        else
            return " not empty";
    }

    public void display() {
        Node curr = top;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
    }
}