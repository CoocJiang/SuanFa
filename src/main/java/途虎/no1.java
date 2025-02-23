package 途虎;

import java.util.ArrayList;
import java.util.Arrays;

public class no1 {
    public static void main(String[] args) {
        System.out.println(maxPriceValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    static int [][] dp ;
    static int n,m;
    static public int maxPriceValue (int[][] grid) {
        // write code here
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for (int i = n-2;i>=0;i--){
            if (grid[i][m-1]!=-1&&dp[i+1][m-1]!=-1){
                dp[i][m-1] = grid[i][m-1]+dp[i+1][m-1];
            }else {
                dp[i][m-1] = -1;
            }
        }
        for (int i = m-2;i>=0;i--){
            if (grid[n-1][i]!=-1&&dp[n-1][i+1]!=-1){
                dp[n-1][i] = grid[n-1][i]+dp[n-1][i+1];
            }else {
                dp[n-1][i] = -1;
            }
        }

        for (int i = n-2;i>=0;i--){
            for (int j = m-2;j>=0;j--){
               if (grid[i][j]==-1||(dp[i+1][j]==-1&&dp[i][j+1]==-1)){
                   dp[i][j]= -1;
               }else {
                   dp[i][j] = grid[i][j]+Math.max(dp[i+1][j],dp[i][j+1]);
               }
            }
        }
        return dp[0][0];
    }

    private int process(int[][] grid, int x, int y) {
        if (dp[x][y]!=-2){
            return dp[x][y];
        }
        if (x==grid.length-1&&y == grid.length-1){
            return grid[grid.length-1][grid[0].length-1];
        }else {
            int p1 = Integer.MIN_VALUE;
            int p2 = Integer.MIN_VALUE;
            if (x<n-1&&grid[x+1][y]!=-1){
                p1 =grid[x+1][y] + process(grid,x+1,y);
            }
            if (y<m-1&&grid[x][y+1]!=-1){
                p2 =grid[x][y+1] + process(grid,x,y+1);
            }
            dp[x][y] = Math.max(p1,p2);
            return dp[x][y];
        }
    }


}
