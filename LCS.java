import java.util.Scanner; 
 
public class LCSAlgorithm  
{ 
    public static int[][] computeLCS(String X, String Y)  
    { 
        int m = X.length(), n = Y.length(); 
        int[][] dp = new int[m+1][n+1]; 
        for (int i=1; i<=m; i++)  
        { 
            for (int j=1; j<=n; j++)  
            { 
                if (X.charAt(i-1) == Y.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1] + 1; 
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
            } 
        } 
        return dp; 
    } 
 
    public static String buildLCS(int[][] dp, String X, String Y)  
    { 
        int m = X.length(); 
        int n = Y.length(); 
        StringBuilder sb = new StringBuilder(); 
        while (m > 0 && n > 0)  
        { 
            if (X.charAt(m-1) == Y.charAt(n-1))  
            { 
                sb.append(X.charAt(m-1)); 
                m--; n--; 
            }  
            else if (dp[m-1][n] > dp[m][n-1]) 
                m--; 
            else 
                n--; 
        } 
        return sb.reverse().toString();
 } 
 
    public static void main(String[] args)  
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter first string: "); 
        String X = sc.nextLine(); 
        System.out.print("Enter second string: "); 
        String Y = sc.nextLine(); 
 
        int[][] dp = computeLCS(X, Y); 
        String lcs = buildLCS(dp, X, Y); 
        System.out.println("Longest Common Subsequence: " + lcs); 
        System.out.println("Length of LCS: " + lcs.length()); 
        sc.close(); 
    } 
}


  
