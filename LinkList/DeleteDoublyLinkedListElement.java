import java.util.Scanner;

public class DeleteDoublyLinkedListElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(3);
        list.push(5);
        list.push(7);
        list.push(9);
        list.push(11);
        System.out.print("\nDisplay list : ");
        list.display();
        System.out.print("\nDisplay Reverse list : ");
        list.displayR();
        System.out.println("\nElement postion want to delete : ");
        list.delete(sc.nextInt());
        System.out.print("\nDisplay list : ");
        list.display();
        System.out.print("\nDisplay Reverse list : ");
        list.displayR();

    }
}

class LinkedList {
    class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            prev = null;
            this.data = data;
            next = null;
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

    public void delete(int pos) {
        try {
            Node curr = head;
            if (pos == 1) {
                head = head.next;
                head.prev = null;
                curr = null;
            } else {
                for (int i = 1; i < pos; i++) {
                    curr = curr.next;
                }
                System.out.print("Deleting element : " + curr.data);

                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                    curr.prev.next = curr.next;

                } else {
                    tail = tail.prev;
                    tail.next = null;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(" Invaild position :error --> " + e);
        }
    }
}