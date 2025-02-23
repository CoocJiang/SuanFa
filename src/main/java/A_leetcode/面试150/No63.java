package A_leetcode.面试150;

public class No63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length<=1&&obstacleGrid[0].length<=1){
            if(obstacleGrid[0][0]==1){
                return 0;
            }else{
                return 1;
            }
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        return process(0,0,obstacleGrid);
    }
    public static int process(int row ,int col ,int[][] obstacleGrid){
        //basecase
        if (row==obstacleGrid.length-1&&col==obstacleGrid[0].length-1){
            return 1;
        }
        int p1 =0;
        int p2 = 0;
        //又2情况
        if (row+1<obstacleGrid.length&&obstacleGrid[row+1][col]!=1){
            p1 = process(row+1,col,obstacleGrid);
        }
        if (col+1<obstacleGrid[0].length&&obstacleGrid[row][col+1]!=1){
            p2 = process(row,col+1,obstacleGrid);
        }
        return p1+p2;
    }

    //动态规划优化
    public static int process1(int[][] obstacleGrid){
        if(obstacleGrid.length<=1&&obstacleGrid[0].length<=1){
            if(obstacleGrid[0][0]==1){
                return 0;
            }else{
                return 1;
            }
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[obstacleGrid.length-1][obstacleGrid[0].length-1] = 1;
        for (int i = obstacleGrid.length-2;i>=0;i-- ){
            if (obstacleGrid[i][obstacleGrid[0].length-1]!=1){
                dp[i][obstacleGrid[0].length-1] = dp[i+1][obstacleGrid[0].length-1];
            }
        }
        for (int i = obstacleGrid[0].length-2;i>=0;i-- ){
            if (obstacleGrid[obstacleGrid.length-1][i]!=1){
                dp[obstacleGrid.length-1][i] = dp[obstacleGrid.length-1][i+1];
            }
        }
        for (int row = obstacleGrid.length-2;row>=0;row-- ){
            for (int col=obstacleGrid[0].length-2;col>=0;col--){
                int p1 =0;
                int p2 = 0;
                //又2情况
                if (obstacleGrid[row+1][col]!=1){
                    p1 = dp[row+1][col];
                }
                if (col+1<obstacleGrid[0].length&&obstacleGrid[row][col+1]!=1){
                    p2 = dp[row][col+1];
                }
                dp[row][col] = p1+p2;
            }
        }
        return dp[0][0];
    }
}
