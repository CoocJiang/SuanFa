package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No317_q3 {


//    public long maximumValueSum(int[][] board) {
//
//        int m = board[0].length;
//        int n = board.length;
//        boolean [][] arr  = new boolean[n][m];
//        int [][] dp = new int[n][m];
//
//        int [] copy;
//        for (int i = 0;i<n;i++){
//            copy = Arrays.copyOf(board[i],m);
//            int l = 0;
//            Arrays.sort(copy);
//            for (int j = 0;j<m;j++){
//
//            }
//        }
//
//    }
    public static void main(String[] args) {
        int[][] board = {
                {83, -5, -11},
                {-4, -82, 51},
                {-37, -36, -84}
        };
        System.out.println(maximumValueSum(board));
    }
    static boolean [] col;
    static int m,n;

    static long [][] dp;
    public static long maximumValueSum(int[][] board) {
         m = board[0].length;
         n = board.length;
        col = new boolean[m];
        dp = new long[n+1][4];
        return dfs(0,0,0,board);
    }

    public static long  dfs(int index,int row,long count,int[][] board){
        if (index==3){
            dp[row][index] = count;
            return count;
        }else {
            long max = Integer.MIN_VALUE;
            if (row<n){
                for (int i = 0;i<m;i++){
                    if (!col[i]){
                        col[i] = true;
                        max = Math.max(max,dfs(index+1,row+1,count+board[row][i],board));
                        col[i] =false;
                    }
                }
                max = Math.max(max,dfs(index,row+1,count,board));
                dp[row][index] = max;
                return max;
            }else {
                dp[row][index] = Integer.MIN_VALUE;
                return Integer.MIN_VALUE;
            }
        }
    }
}
