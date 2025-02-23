package shope;

public class No1 {


    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    public static int minPathSum(int[][] grid) {
        // write code here
        int n = grid.length;;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for (int i = n-2;i>=0;i--){
            dp[i][m-1] =grid[i][m-1]+dp[i+1][m-1];
        }
        for (int j = m-2;j>=0;j--){
            dp[n-1][j] = grid[n-1][j]+dp[n-1][j+1];
        }
        for (int i = n-2;i>=0;i--){
            for (int j = m-2;j>=0;j--){
                dp[i][j] =grid[i][j]+ Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
