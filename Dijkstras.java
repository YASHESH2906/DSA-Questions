import java.util.*; 
 
public class DijkstraSSSP  
{ 
    static final int INF = Integer.MAX_VALUE; 
 
    static int minDistance(int[] dist, boolean[] visited, int V)  
    { 
        int min = INF, minIdx = -1; 
        for (int v = 0; v < V; v++) 
            if (!visited[v] && dist[v] < min)  
            { 
                min = dist[v]; 
                minIdx = v; 
            } 
        return minIdx; 
    } 
 
    public static void dijkstra(int[][] graph, int src, int V)  
    { 
        int[] dist = new int[V];
 boolean[] visited = new boolean[V]; 
        Arrays.fill(dist, INF); 
        Arrays.fill(visited, false); 
 
        dist[src] = 0; 
        for (int count = 0; count < V - 1; count++)  
        { 
            int u = minDistance(dist, visited, V); 
            if (u == -1) break; 
            visited[u] = true; 
            for (int v = 0; v < V; v++) 
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && 
                    dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        System.out.println("Vertex\tDistance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + "\t" + (dist[i] == INF ? "INF" : dist[i])); 
    } 
 
    public static void main(String[] args)  
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of vertices: "); 
        int V = sc.nextInt(); 
        int[][] graph = new int[V][V]; 
        System.out.println("Enter adjacency matrix (row by row, 0 means no 
edge):"); 
        for (int i = 0; i < V; i++) 
            for (int j = 0; j < V; j++) 
                graph[i][j] = sc.nextInt(); 
        System.out.print("Enter source vertex: "); 
        int src = sc.nextInt(); 
        dijkstra(graph, src, V); 
        sc.close(); 
    } 
}
