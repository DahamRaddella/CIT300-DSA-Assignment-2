public class MyLinkedList {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted " + value + " to Linked List.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted " + value + " from Linked List.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value " + value + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted " + value + " from Linked List.");
        }
    }

    public boolean search(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Found " + value + " at node index " + index + ".");
                return true;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Value " + value + " not found in Linked List.");
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}