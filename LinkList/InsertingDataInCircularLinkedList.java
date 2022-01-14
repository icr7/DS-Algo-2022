public class InsertingDataInCircularLinkedList {
    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.display();

    }
}

class linkedList {
    Node head = null;
    Node tail;

    class Node {
        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
            this.nextNode = head;
        }
    }

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.nextNode = new Node(data);
            tail = tail.nextNode;
        }

    }

    public void display() {
        Node currentNode = head;
        do {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        } while (currentNode != head);
        System.out.println("data after last node : " + currentNode.data);

    }
}
