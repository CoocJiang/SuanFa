package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No329 {

    public static void main(String[] args) {
        int[][] array = {
                {1,2}
        };
        System.out.println(longestIncreasingPath(array));
    }
    static int[][] dp ;
    static int [] move = {1,0,-1,0,1};
    static int n;
    static int m;
    public static int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int max = 0;
        dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                max = Math.max(max,process(matrix,i,j));
            }
        }
        return max;
    }
    public static int process(int [][]matrix,int row ,int col){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int ans = 1;
        for(int i = 1;i<move.length;i++){
            int nrow = row+move[i-1];
            int ncol = col+move[i];
            if(nrow>=0&&ncol>=0&&ncol<m&&nrow<n&&matrix[nrow][ncol]>matrix[row][col]){
                ans = Math.max(ans,process(matrix,nrow,ncol)+1);
            }
        }
        dp[row][col] = ans;
        return ans;
    }
}
