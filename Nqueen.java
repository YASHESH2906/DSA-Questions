import java.util.Scanner; 
 
public class NQueens  
{ 
    static int N; 
    static int[][] board; 
 
    static boolean isSafe(int row, int col)  
    { 
        // Check left side of row 
        for (int i = 0; i < col; i++) 
            if (board[row][i] == 1) return false; 
 
        // Check upper-left diagonal 
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) return false; 
 
        // Check lower-left diagonal 
        for (int i = row, j = col; i < N && j >= 0; i++, j--) 
            if (board[i][j] == 1) return false; 
 
        return true;
       } 
 
    static boolean solveNQueens(int col)  
    { 
        if (col == N)  
        { 
            printSolution(); 
            return true; 
        } 
 
        boolean res = false; 
        for (int i = 0; i < N; i++)  
        { 
            if (isSafe(i, col))  
            { 
                board[i][col] = 1; 
                res = solveNQueens(col + 1) || res; 
                board[i][col] = 0; // backtrack 
            } 
        } 
        return res; 
    } 
 
    static void printSolution()  
    { 
        for (int i = 0; i < N; i++)  
        { 
            for (int j = 0; j < N; j++)  
            { 
                if (board[i][j] == 1) System.out.print("Q "); 
                else System.out.print("_ "); 
            } 
            System.out.println(); 
        } 
        System.out.println(); 
    } 
 
    public static void main(String[] args)  
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter board size N: "); 
        N = sc.nextInt(); 
        board = new int[N][N];
        if (!solveNQueens(0))  
        { 
            System.out.println("No solution exists for N = " + N); 
        } 
        sc.close(); 
    } 
}
