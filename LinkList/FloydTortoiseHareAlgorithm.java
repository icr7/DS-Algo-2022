public class FloydTortoiseHareAlgorithm {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.pushc(3);
        list.pushc(4);
        list.pushc(5);
        list.pushc(6);

        list.display();
        list.check();
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;
    Node chead = null;
    Node ctail = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, int diff) {
            this.data = data;
            this.next = chead;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void pushc(int data) {
        Node newNode = new Node(data, 1);
        if (chead == null) {
            chead = newNode;
            if (tail != null) {
                tail.next = chead;
                ctail = chead;
            } else {
                head = chead;
                ctail = chead;
            }

        } else {
            ctail.next = newNode;
            ctail = ctail.next;
        }
    }

    public void display() {
        int x = 0;
        Node curr = head;
        System.out.println(curr.data);
        curr = curr.next;
        while (curr != null) {
            if (curr == chead) {
                x++;
            }
            if (x == 2) {
                break;
            }
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    // Node hare=head;// getting null dont know why?
    // Node tortoise=head;// getting null dont know why?

    public void check() {
        Node hare = head;
        Node tortoise = head;
        int i = 0;
        while (hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise) {
                i++;
                break;
            }
        }

        if (i == 0) {
            System.out.println("No circular list spotted");
        } else {
            Node curr = head;
            while (curr != tortoise) {
                curr = curr.next;
                tortoise = tortoise.next;
            }
            System.out.println("circular list spotted at data: " + hare.data);
            System.out.println("starting point of cycle: " + curr.data);
        }

    }

}