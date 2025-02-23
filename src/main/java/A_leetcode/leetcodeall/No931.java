package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Map;

public class No931 {

    static int [][] dp;
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        dp = new int[n][n];
        for (int i = n-1;i>=0;i--){
           dp[n-1][i] = matrix[n-1][i];
        }
        for (int i = n-2;i>=0;i--){
           dp[i][0] =matrix[i][0] + Math.min(dp[i+1][1],dp[i+1][0]);
            for (int j = 1;j<n-1;j++){
                int min = Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i+1][j-1]));
                dp[i][j] = matrix[i][j]+min;
            }
            dp[i][n-1] =matrix[i][n-1] +  Math.min(dp[i+1][n-1],dp[i+1][n-2]);
        }
        for (int i = 0;i<n;i++){
            ans = Math.min(dp[0][i],ans);
        }
        return ans;
    }
}
