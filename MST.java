import java.util.*; 
 
public class PrimsAlgorithm  
{ 
    static final int INF = Integer.MAX_VALUE; 
 
    public static void primMST(int[][] graph, int V)  
    { 
        int[] key = new int[V]; 
        boolean[] mstSet = new boolean[V]; 
        int[] parent = new int[V]; 
 
        Arrays.fill(key, INF); 
        Arrays.fill(mstSet, false); 
 
        key[0] = 0;      // Start at vertex 0 
        parent[0] = -1;  // Start node has no parent 
 
        for (int count = 0; count < V-1; count++)  
        { 
            // Pick min key vertex not in MST 
            int u = minKey(key, mstSet, V); 
            mstSet[u] = true; 
 
            // Update keys and parent for adjacent vertices 
            for (int v = 0; v < V; v++)  
            { 
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v])  

  { 
                    key[v] = graph[u][v]; 
                    parent[v] = u; 
                } 
            } 
        } 
 
        // Display MST edges and weight 
        int totalWeight = 0; 
        System.out.println("Edge   Weight"); 
        for (int i = 1; i < V; i++)  
        { 
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]); 
            totalWeight += graph[i][parent[i]]; 
        } 
        System.out.println("Total weight of MST: " + totalWeight); 
    } 
 
    static int minKey(int[] key, boolean[] mstSet, int V)  
    { 
        int min = INF, minIndex = -1; 
        for (int v = 0; v < V; v++)  
        { 
            if (!mstSet[v] && key[v] < min)  
            { 
                min = key[v]; 
                minIndex = v; 
            } 
        } 
        return minIndex; 
    } 
 
    public static void main(String[] args)  
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of vertices: "); 
        int V = sc.nextInt(); 
        int[][] graph = new int[V][V]; 
 
        System.out.println("Enter adjacency matrix (row by row, use 0 for no 
edge):"); 
        for (int i = 0; i < V; i++) 
            for (int j = 0; j < V; j++)
            graph[i][j] = sc.nextInt(); 
 
        primMST(graph, V); 
        sc.close(); 
    } 
}  








              
