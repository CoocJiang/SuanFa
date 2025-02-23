package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No3148 {
    public static void main(String[] args) {
        // 创建主列表
        List<List<Integer>> grid = new ArrayList<>();

        // 创建第一行并添加到主列表
        List<Integer> row1 = new ArrayList<>();
        row1.add(4);
        row1.add(3);

        grid.add(row1);

        // 创建第二行并添加到主列表
        List<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(3);

        grid.add(row2);




        System.out.println(maxScore(grid));
    }

    static int n;
    static int m;
    static int [][]dp;
    public static int maxScore(List<List<Integer>> grid) {
        n = grid.size();
        m = grid.get(0).size();
        dp= new int[n][m];
        int [][] grid2 = new int[n][m];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                grid2[i][j] = grid.get(i).get(j);
            }
        }
        dp[n-1][m-2] = grid2[n-1][m-1] - grid2[n-1][m-2];
        dp[n-2][m-1] = grid2[n-1][m-1] - grid2[n-2][m-1];
        int max = Math.max(dp[n-1][m-2],dp[n-2][m-1]);
        for (int y = m-3;y>=0;y--){
            int cur = Integer.MIN_VALUE;
            for (int j = y+1;j < m;j++){
                cur= Math.max(grid2[n-1][j] - grid2[n-1][y] + Math.max(dp[n-1][j],0),cur);
            }
            dp[n-1][y] = cur;
            max = Math.max(dp[n-1][y],max);
        }
        for (int x = n-3;x>=0;x--){
            int cur = Integer.MIN_VALUE;
            for (int i = x+1;i <n ;i++){
                cur = Math.max(grid2[i][m-1] - grid2[x][m-1] + Math.max(0,dp[i][m-1]),cur);
            }
            dp[x][m-1] = cur;
            max = Math.max(dp[x][m-1],max);
        }
        for (int x = n-2;x>=0;x--){
            for (int y = m-2;y>=0;y--){
                int cur = Integer.MIN_VALUE;
                cur= Math.max(grid2[x][y+1] - grid2[x][y] + Math.max(dp[x][y+1],0),cur);
                cur = Math.max(grid2[x+1][y] - grid2[x][y] + Math.max(dp[x+1][y],0),cur);
                dp[x][y] = cur;
                max = Math.max(dp[x][y],max);
            }
        }
        return max;
    }
}
