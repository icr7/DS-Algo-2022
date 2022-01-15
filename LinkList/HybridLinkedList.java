public class HybridLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        System.out.println("single linked List--->");
        list.display();
        list.push2C(11);
        list.push2C(12);
        list.push2C(13);
        list.push2C(14);
        list.push2C(15);
        System.out.println("\ncircular linked list--->");
        list.displayC();
        System.out.println("\nhybrid linked list--->");
        //list.displayH();//once this trigger then there is no go back display()
        // and displayC() will not work cuz now it become hybrid..and will also change
        // other objects.. better to go with new Linked list
        LinkedList hybridList = new LinkedList();
        hybridList.head = list.head;
        hybridList.tail = list.tail;
        hybridList.tail.next = list.circularHead;
        hybridList.displayH();

    }
}

class LinkedList {
    Node head = null;
    Node tail = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, int diff) {// diff is just used for constructor overloading
            this.data = data;
            this.next = circularHead;
        }
    }

    Node circularHead = null;
    Node circularTail = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public void push2C(int data) {
        Node newNode = new Node(data, 1);
        if (circularHead == null) {
            circularHead = newNode;
            circularTail = circularHead;
        } else {
            circularTail.next = newNode;
            circularTail = circularTail.next;
        }
    }

    public void displayC() {
        Node currentNode = circularHead;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != circularHead);
    }

    public void displayH() {
        Node currentNode = head;
        for (int i = 0; i < 21; i++) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }


}
