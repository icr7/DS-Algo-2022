public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        System.out.println("\n display list");
        list.display();
        System.out.println("\n display reverse list");
        list.displayR();
    }
}

class LinkedList {
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

    Node head = null;
    Node tail = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public void displayR() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
    }
}