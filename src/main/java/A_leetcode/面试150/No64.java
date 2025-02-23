package A_leetcode.面试150;

public class No64 {
    public static void main(String[] args) {
        int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum2(grid));
    }

    public static int minPathSum(int[][] grid) {
        return process(0,0,grid);
    }

    public static int process(int row,int col,int [] [] grid){
        //每个位置有两种选择，向下或者向左
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        int counts  = grid[row][col];
        //向右边
        if (col+1<grid[0].length){
            p2 = grid[row][col] + process(row,col+1,grid);
        }

        if (row+1<grid.length){
             p1 = grid[row][col] + process(row+1,col,grid);
        }
        if (p1==Integer.MAX_VALUE&&p2==Integer.MAX_VALUE){
            return counts;
        }
        counts  = Math.min(p1,p2);
        return counts;
    }

    public static int minPathSum2(int[][] grid){
        int [][] dp = new int [grid.length][grid[0].length];
        dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        //先单独把最下和最右边填入
        for (int col = grid[0].length-2;col>=0;col--){
            dp[grid.length-1][col] = grid[grid.length-1][col]+dp[grid.length-1][col+1];
        }

        for (int index = grid.length-2;index>=0;index--){
            dp[index][grid[0].length-1] = grid[index][grid[0].length-1]+dp[index+1][grid[0].length-1];
        }

        for (int index = grid.length-2;index>=0;index--){
            for (int col = grid[0].length-2;col>=0;col--){
                int p2 = grid[index][col] + dp[index][col+1];
                int  p1 = grid[index][col] + dp[index+1][col];
               dp[index][col] = Math.min(p1,p2);
            }
        }
        return dp[0][0];
    }
}
