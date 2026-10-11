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
            System.out.println("1. Push | 2. Pop | 3. Peek | 4. Display | 5. Back");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            switch (ch) {
                case 1:
                    System.out.print("Enter value to push: ");
                    stack.push(getIntInput());
                    break;
                case 2: stack.pop(); break;
                case 3: stack.peek(); break;
                case 4: stack.display(); break;
                case 5: back = true; break;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private static void handleQueueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue | 2. Dequeue | 3. Peek Front | 4. Display | 5. Back");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            switch (ch) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    queue.enqueue(getIntInput());
                    break;
                case 2: queue.dequeue(); break;
                case 3: queue.peekFront(); break;
                case 4: queue.display(); break;
                case 5: back = true; break;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private static void handleArrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert | 2. Delete | 3. Display | 4. Back");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            if (ch == 1) {
                System.out.print("Enter value to insert: ");
                arrayHandler.insert(getIntInput());
            } else if (ch == 2) {
                System.out.print("Enter value to delete: ");
                arrayHandler.delete(getIntInput());
            } else if (ch == 3) {
                arrayHandler.display();
            } else if (ch == 4) {
                back = true;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void handleLinkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert | 2. Delete | 3. Search | 4. Display | 5. Back");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            if (ch == 1) {
                System.out.print("Enter value to insert: ");
                linkedList.insert(getIntInput());
            } else if (ch == 2) {
                System.out.print("Enter value to delete: ");
                linkedList.delete(getIntInput());
            } else if (ch == 3) {
                System.out.print("Enter value to search: ");
                linkedList.search(getIntInput());
            } else if (ch == 4) {
                linkedList.display();
            } else if (ch == 5) {
                back = true;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void handleSearchingMenu() {
        System.out.println("\n--- SEARCHING OPERATIONS ---");
        System.out.println("1. Linear Search | 2. Binary Search | 3. Back");
        System.out.print("Enter choice: ");
        int ch = getIntInput();
        if (ch == 1) {
            System.out.print("Enter target value to search: ");
            arrayHandler.linearSearch(getIntInput());
        } else if (ch == 2) {
            System.out.print("Enter target value to search: ");
            arrayHandler.binarySearch(getIntInput());
        }
    }

    private static void handleGraphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex | 2. Add Edge | 3. Display Graph | 4. BFS Traversal | 5. DFS Traversal | 6. Back");
            System.out.print("Enter choice: ");
            int ch = getIntInput();
            if (ch == 1) {
                System.out.print("Enter vertex name (e.g., A): ");
                graph.addVertex(scanner.next());
            } else if (ch == 2) {
                System.out.print("Enter source vertex: ");
                String src = scanner.next();
                System.out.print("Enter destination vertex: ");
                String dest = scanner.next();
                graph.addEdge(src, dest);
            } else if (ch == 3) {
                graph.displayGraph();
            } else if (ch == 4) {
                System.out.print("Enter start vertex for BFS: ");
                graph.bfsTraversal(scanner.next());
            } else if (ch == 5) {
                System.out.print("Enter start vertex for DFS: ");
                graph.dfsTraversal(scanner.next());
            } else if (ch == 6) {
                back = true;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void handlePerformanceMenu() {
        System.out.println("\n--- PERFORMANCE COMPARISON ---");
        // Test Data for Searching 
        int[] testData = {15, 22, 34, 48, 59, 61, 75, 88, 92, 105};
        System.out.print("Enter a target value to test Search Algorithms (e.g., 75): ");
        int searchTarget = getIntInput();
        
        System.out.print("Enter a start vertex to test Graph Traversals (e.g., A): ");
        String startVertex = scanner.next();
        
        analyzer.compareSearchPerformance(testData, searchTarget);
        analyzer.compareGraphTraversal(graph, startVertex);
    }

    private static void displayAll() {
        System.out.println("\n--- CURRENT SYSTEM STATE ---");
        stack.display();
        queue.display();
        arrayHandler.display();
        linkedList.display();
        graph.displayGraph();
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}