package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No2435 {


    public static void main(String[] args) {
        int[][] array = {
                {1, 5, 3, 7, 3, 2, 3, 5}
        };
        System.out.println(numberOfPaths(array, 29));
    }

    static int mod = 1000000007;
    static long [][][] dp;
    public  static int numberOfPaths(int[][] grid, int k) {
        dp = new long[grid.length][grid[0].length][k+1];
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        dp[grid.length-1][grid[0].length-1][k] = 1;
        dp[grid.length-1][grid[0].length-1][0] = 1;
        for (int j = grid[0].length-1;j>=0;j--){
            long ans = 0;
            int sum = grid[grid.length-1][j]%k;
            if (j+1<grid[0].length){
//                dp[grid.length-1][j+1][]=(ans+dp[grid.length-1][j+1][grid[grid.length-1][j]])%mod;
            }
        }
        for (int i = grid.length-1;i>=0;i--){
            for (int j = grid[0].length-1;j>=0;j--){
                long ans = 0;
                int sum = grid[i][j]%k;
                if (j+1<grid[0].length){
                    ans=(ans+dp[i][j+1][grid[i][j]])%mod;
                }
            }
        }

        int x= 0;
        int y = 0;
        return process(grid,x,y,0,k);
    }
    private static int process(int[][] grid, int x, int y,int sum,int k) {
        if (x==grid.length-1&&y==grid[0].length-1){
            sum=(sum+grid[x][y])%k;
            dp[x][y][sum] = sum%k==0 ? 1:0;
            return(int) dp[x][y][sum];
        }
        sum=(sum+grid[x][y])%k;
        if (dp[x][y][sum]!=-1){
            return(int) dp[x][y][sum];
        }
        long ans = 0;
        if (x+1<grid.length){
            ans=(ans+process(grid,x+1,y,sum,k))%mod;
        }
        if (y+1<grid[0].length){
            ans=(ans+process(grid,x,y+1,sum,k))%mod;
        }
        ans = ans%mod;
        dp[x][y][sum] = ans;
        return (int) ans;
    }
}
