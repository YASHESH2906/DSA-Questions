import java.util.*;

public class Student {
    static final int MAX = 100;

    // BFS function
    static void bfs(int[][] graph, int vertices, int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        // Mark the start vertex as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue
            System.out.print(current + " ");

            // Visit all adjacent unvisited vertices
            for (int i = 0; i < vertices; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter starting vertex (0 to " + (vertices - 1) + "): ");
        int start = scanner.nextInt();

        bfs(graph, vertices, start);

        scanner.close();
    }
}