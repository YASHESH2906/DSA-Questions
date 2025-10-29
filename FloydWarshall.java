import java.util.*; 
 
public class FloydWarshall  
{ 
    static final int INF = 100000000; 
 
    public static void floydWarshall(int[][] dist, int V)  
    { 
        for (int k = 0; k < V; k++) 
            for (int i = 0; i < V; i++) 
                for (int j = 0; j < V; j++) 
                    if (dist[i][k] < INF && dist[k][j] < INF && 
                        dist[i][j] > dist[i][k] + dist[k][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
 
        // Output result 
        System.out.println("All Pair Shortest Path Matrix:"); 
        for (int i = 0; i < V; ++i)  
        { 
            for (int j = 0; j < V; ++j)  
            { 
                if (dist[i][j] == INF) System.out.print("INF "); 
                else System.out.print(dist[i][j] + " "); 
            } 
            System.out.println(); 
        } 
    } 
 
    public static void main(String[] args)  
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of vertices: "); 
        int V = sc.nextInt(); 
        int[][] graph = new int[V][V]; 
 
        System.out.println("Enter adjacency matrix (use " + INF + " for no edge):"); 
        for (int i = 0; i < V; i++) 
            for (int j = 0; j < V; j++) 
                graph[i][j] = sc.nextInt(); 
 
        floydWarshall(graph, V); 
        sc.close();
         } 
} 
 
