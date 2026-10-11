import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
        System.out.println("Vertex added: " + vertex);
    }

    public void addEdge(String source, String destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Undirected graph
        System.out.println("Edge added between " + source + " and " + destination);
    }

    public void displayGraph() {
        if(adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Graph Adjacency List:");
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    public void bfsTraversal(String startVertex) {
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Vertex not found for BFS.");
            return;
        }
        System.out.print("BFS Traversal: ");
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfsTraversal(String startVertex) {
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Vertex not found for DFS.");
            return;
        }
        System.out.print("DFS Traversal: ");
        Set<String> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    private void dfsHelper(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}