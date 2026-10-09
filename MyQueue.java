public class MyQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public MyQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Error: Queue Overflow! Cannot enqueue " + value);
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1; // Circular wrap-around
        }
        queueArray[++rear] = value;
        nItems++;
        System.out.println("Successfully enqueued " + value + " to the Queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue Underflow! Queue is empty.");
            return -1;
        }
        int temp = queueArray[front++];
        if (front == maxSize) {
            front = 0; // Circular wrap-around
        }
        nItems--;
        System.out.println("Successfully dequeued " + temp + " from the Queue.");
        return temp;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty. Nothing at front.");
            return -1;
        }
        System.out.println("Front element is: " + queueArray[front]);
        return queueArray[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is currently empty.");
            return;
        }
        System.out.print("Queue elements (Front to Rear): ");
        int count = 0;
        int current = front;
        while (count < nItems) {
            System.out.print(queueArray[current] + " ");
            current = (current + 1) % maxSize;
            count++;
        }
        System.out.println();
    }
}