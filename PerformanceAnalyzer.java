import java.util.Arrays;

public class PerformanceAnalyzer {
    
    public void compareSearchPerformance(int[] data, int target) {
        System.out.println("\n--- PERFORMANCE COMPARISON: SEARCH ---");
        
        if (data == null || data.length == 0) {
            System.out.println("Data array is empty.");
            return;
        }

        // Linear Search Performance
        long startLinear = System.nanoTime();
        int linearSteps = 0;
        boolean foundLinear = false;
        for (int i = 0; i < data.length; i++) {
            linearSteps++;
            if (data[i] == target) {
                foundLinear = true;
                break;
            }
        }
        long endLinear = System.nanoTime();

        // Binary Search Performance (Requires Sorted Array)
        int[] sortedData = Arrays.copyOf(data, data.length);
        Arrays.sort(sortedData);
        
        long startBinary = System.nanoTime();
        int binarySteps = 0;
        boolean foundBinary = false;
        int left = 0, right = sortedData.length - 1;
        while (left <= right) {
            binarySteps++;
            int mid = left + (right - left) / 2;
            if (sortedData[mid] == target) {
                foundBinary = true;
                break;
            }
            if (sortedData[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        long endBinary = System.nanoTime();

        System.out.println("Algorithm       | Steps | Execution Time (ns) | Found");
        System.out.println("-------------------------------------------------------");
        System.out.printf("Linear Search   | %5d | %19d | %b\n", linearSteps, (endLinear - startLinear), foundLinear);
        System.out.printf("Binary Search   | %5d | %19d | %b\n", binarySteps, (endBinary - startBinary), foundBinary);
    }

    public void compareGraphTraversal(Graph graph, String startVertex) {
        System.out.println("\n--- PERFORMANCE COMPARISON: GRAPH TRAVERSAL ---");
        System.out.println("Traversal | Execution Time (ns)");
        System.out.println("-------------------------------");
        
        System.out.println("Measuring BFS...");
        long startBFS = System.nanoTime();
        graph.bfsTraversal(startVertex);
        long endBFS = System.nanoTime();
        
        System.out.println("Measuring DFS...");
        long startDFS = System.nanoTime();
        graph.dfsTraversal(startVertex);
        long endDFS = System.nanoTime();

        System.out.println("\nResults:");
        System.out.printf("BFS       | %19d\n", (endBFS - startBFS));
        System.out.printf("DFS       | %19d\n", (endDFS - startDFS));
    }
}