package src;
public class MyStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Error: Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Successfully pushed " + value + " to the Stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Stack Underflow! Stack is empty.");
            return -1;
        }
        int poppedValue = stackArray[top--];
        System.out.println("Successfully popped " + poppedValue + " from the Stack.");
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty. Nothing to peek.");
            return -1;
        }
        System.out.println("Top element is: " + stackArray[top]);
        return stackArray[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is currently empty.");
            return;
        }
        System.out.print("Stack elements (Top to Bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}