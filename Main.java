import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MyStack stack = new MyStack(5);
    private static MyQueue queue = new MyQueue(5);
    private static ArrayHandler arrayHandler = new ArrayHandler(10);
    private static MyLinkedList linkedList = new MyLinkedList();
    private static Graph graph = new Graph();
    private static PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========================================");
            System.out.println("  DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    handleArrayMenu();
                    break;
                case 2:
                    handleStackMenu();
                    break;
                case 3:
                    handleQueueMenu();
                    break;
                case 4:
                    handleLinkedListMenu();
                    break;
                case 5:
                    handleSearchingMenu();
                    break;
                case 6:
                    handleGraphMenu();
                    break;
                case 7:
                    handlePerformanceMenu();
                    break;
                case 8:
                    displayAll();
                    break;
                case 9:
                    System.out.println("Exiting System. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 9.");
            }
        }
    }

    private static void handleStackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            switch (ch) {
                case 1:
                    System.out.print("Enter value to push: ");
                    stack.push(getIntInput());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void handleQueueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek Front");
            System.out.println("4. Display");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            switch (ch) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    queue.enqueue(getIntInput());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peekFront();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void handleArrayMenu() {
        System.out.println("\n--- ARRAY OPERATIONS ---");
        System.out.println("1. Insert | 2. Display | 3. Back");
        System.out.print("Enter choice: ");
        int ch = getIntInput();
        if (ch == 1) {
            System.out.print("Enter value: ");
            arrayHandler.insert(getIntInput());
        } else if (ch == 2) {
            arrayHandler.display();
        }
    }

    private static void handleLinkedListMenu() {
        System.out.println("\n--- LINKED LIST OPERATIONS ---");
        System.out.println("1. Insert | 2. Display | 3. Back");
        System.out.print("Enter choice: ");
        int ch = getIntInput();
        if (ch == 1) {
            System.out.print("Enter value: ");
            linkedList.insert(getIntInput());
        } else if (ch == 2) {
            linkedList.display();
        }
    }

    private static void handleSearchingMenu() {
        System.out.println("\n--- SEARCHING OPERATIONS ---");
        System.out.println("1. Linear Search | 2. Binary Search | 3. Back");
        System.out.print("Enter choice: ");
        int ch = getIntInput();
        if (ch == 1) arrayHandler.linearSearch(10);
else if (ch == 2) arrayHandler.binarySearch(10);
    }

    private static void handleGraphMenu() {
        System.out.println("\n--- GRAPH OPERATIONS ---");
        System.out.println("1. Display Graph | 2. BFS Traversal | 3. DFS Traversal | 4. Back");
        System.out.print("Enter choice: ");
        int ch = getIntInput();
        if (ch == 1) graph.displayGraph();
        else if (ch == 2) graph.bfsTraversal("A");
        else if (ch == 3) graph.dfsTraversal("A");
    }

    private static void handlePerformanceMenu() {
        analyzer.compareSearchPerformance(new int[]{1, 2, 3, 4, 5}, 3);
        analyzer.compareGraphTraversal(graph, "A");
    }

    private static void displayAll() {
        System.out.println("\n--- CURRENT SYSTEM STATE ---");
        stack.display();
        queue.display();
        arrayHandler.display();
        linkedList.display();
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}