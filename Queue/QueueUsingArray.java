public class QueueUsingArray {
    public static void main(String[] args) {
        Queue list = new Queue();
        for (int i = 1; i < 6; i++) {
            System.out.print("\nAfter " + i + " enqueue ->> ");
            list.enqueue(i * 10);
            list.display();
        }
        System.out.println();
        for (int i = 1; i < 6; i++) {
            System.out.print("\nAfter " + i + " dequeue ->> ");
            list.dequeue();
            list.display();
        }
    }
}

class Queue {
    int max = 1000;
    int arr[] = new int[max];
    int rear = -1, front = -1;

    public void enqueue(int data) {
        if (front == -1) {
            front++;
            rear++;
            arr[rear] = data;
        } else {
            rear++;
            arr[rear] = data;
        }
    }

    public void dequeue() {
        arr[front] = 0;
        front++;
    }

    public void display() {
        int curr = front;
        while (curr <= rear) {
            System.out.print(arr[curr] + " ");
            curr++;
        }
    }
}