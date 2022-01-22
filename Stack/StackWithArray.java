public class StackWithArray {
    public static void main(String[] args) {
        Stack list = new Stack();
        System.out.println("inserting 10, 20, 30, 40, 50 into stack....");
        System.out.println("\npeek--> " + list.peek());
        for (int i = 1; i < 6; i++) {
            list.push(10 * i);
            System.out.print("Stack after " + i + " insertion --> ");
            list.display();
            System.out.println("\npeek--> " + list.peek());
        }

        for (int i = 1; i < 6; i++) {
            System.out.print("\nStack after " + i + " pop -->");
            list.pop();
            list.display();
            System.out.println("\npeek--> " + list.peek());
        }
    }
}

class Stack {
    private int max = 1000;
    private int arr[] = new int[max];
    private int top = -1;

    public void push(int data) {
        if (top > max - 1) {
            System.out.println("Stack overflow");
        } else {
            top++;
            arr[top] = data;
        }
    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }

    public void pop() {
        arr[top] = 0;
        top--;
    }

    public void display() {
        int curr = top;
        while (curr != -1) {
            System.out.print(arr[curr] + " ");
            curr--;
        }
    }

}
