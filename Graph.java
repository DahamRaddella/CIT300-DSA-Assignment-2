import java.util.*;

// Piyumika - Graph Implementation
public class Graph {
    private Map<String, List<String>> adjList;
    private int numVertices;
    private int numEdges;

    public Graph() {
        adjList = new HashMap<>();
        numVertices = 0;
        numEdges = 0;
    }

    // O(1) - Add Vertex
    public void addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
            numVertices++;
        }
    }

    // O(1) - Add Edge
    public void addEdge(String from, String to) {
        // Vertex nattam auto add wenawa
        addVertex(from);
        addVertex(to);
        
        // Duplicate check karala add karanne
        if (!adjList.get(from).contains(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from); // Undirected graph
            numEdges++;
        }
    }

    // Display Graph - O(V + E)
    public void display() {
        System.out.println("Graph (Adjacency List):");
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
        System.out.println("Vertices: " + numVertices + ", Edges: " + numEdges);
    }

    // BFS - Breadth First Search O(V + E)
    // V = vertices, E = edges
    // Queue ekak use karala level by level yanne
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex not found: " + start);
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS from " + start + ": ");

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

    // DFS - Depth First Search O(V + E)
    // Stack / Recursion use karala deep yanne
    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex not found: " + start);
            return;
        }

        Set<String> visited = new HashSet<>();
        System.out.print("DFS from " + start + ": ");
        dfsHelper(start, visited);
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

    public int getVertexCount() {
        return numVertices;
    }

    public int getEdgeCount() {
        return numEdges;
    }
}