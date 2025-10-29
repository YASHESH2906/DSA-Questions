import java.util.*; 
 
public class HamiltonianCycle  
{ 
    private int V; 
    private int[][] graph; 
    private int[] path; 
     
    public HamiltonianCycle(int[][] graph)  
    { 
        this.graph = graph; 
        this.V = graph.length; 
        this.path = new int[V]; 
        Arrays.fill(path, -1); 
    } 
 
    private boolean isSafe(int v, int pos)  
    {
       if (graph[path[pos - 1]][v] == 0) return false; 
        for (int i = 0; i < pos; i++) if (path[i] == v) return false; 
        return true; 
    } 
 
    private boolean hamCycleUtil(int pos)  
    { 
        if (pos == V)  
        { 
            return graph[path[pos - 1]][path[0]] == 1; 
        } 
        for (int v = 1; v < V; v++)  
        { 
            if (isSafe(v, pos))  
            { 
                path[pos] = v; 
                if (hamCycleUtil(pos + 1)) return true; 
                path[pos] = -1; // backtrack 
            } 
        } 
        return false; 
    } 
 
    public boolean hamCycle()  
    { 
        path[0] = 0; 
        if (!hamCycleUtil(1))  
        { 
            System.out.println("No solution exists"); 
            return false; 
        } 
        printSolution(); 
        return true; 
    } 
 
    private void printSolution()  
    { 
        System.out.print("Hamiltonian Cycle: "); 
        for (int v : path) System.out.print(v + " "); 
        System.out.println(path[0]); 
    } 
 
    public static void main(String[] args) 
  { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of vertices: "); 
        int V = sc.nextInt(); 
        int[][] graph = new int[V][V]; 
        System.out.println("Enter adjacency matrix:"); 
        for (int i = 0; i < V; i++) 
            for (int j = 0; j < V; j++) 
                graph[i][j] = sc.nextInt(); 
        HamiltonianCycle hc = new HamiltonianCycle(graph); 
        hc.hamCycle(); 
        sc.close(); 
    } 
}
