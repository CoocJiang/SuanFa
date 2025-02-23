package A_leetcode.面试150;

import sun.security.mscapi.PRNG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NO130 {
    //给你一个 m x n 的矩阵 board ，
    // 由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    public static void main(String[] args) {
            // 定义新的网格
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}
        };
            solve(board);
    }
    public static void solve1(char[][] board) {
        int [][] dp = new int[board.length][board[0].length];
        int N = board.length;;
        int M = board[0].length;
       //从边上的O开始找，所有与他连接的O都不能变成X
        for (int i=0;i<M;i++){
            process(board,0,i,dp);
            process(board,N-1,i,dp);
        }
        for (int i=0;i<N;i++){
            process(board,i,0,dp);
            process(board,i,M-1,dp);
        }
        //然后再把剩余在X里的O给变成X
        for (int i=1;i<N-1;i++){
            for (int j=1;j<M-1;j++){
                process2(board,dp,i,j);
            }
        }
    }

    private static void process2(char[][] board,int[][]dp,int row ,int col) {
        //
        if (dp[row][col]==2){
            return;
        }
        if (board[row][col]=='O'){
            board[row][col] = 'X';
        }
    }

    public static void process(char[][] board,int row ,int col,int[][] dp) {
        if (board[row][col]!='O'){
            return;
        }
        if (dp[row][col]==2){
            return ;
        }
        dp[row][col]=2;
        if (row+1 < board.length){
            process(board,row+1,col,dp);
        }
        if (row-1 >= 0){
            process(board,row-1,col,dp);
        }
        if (col+1 < board[0].length){
            process(board,row,col+1,dp);
        }
        if (col-1 >= 0){
            process(board,row,col-1,dp);
        }
    }



    public static void solve(char[][] board) {
        List<int []> list = new ArrayList<>();
        for (int i = 1;i<board.length-1;i++){
            if (board[i][0]=='O'){
                dfs(i,1,board,list);
            }
            if (board[i][board[0].length-1]=='O'){
                dfs(i,board[0].length-2,board,list);
            }
        }
        for (int j = 1;j<board[0].length-1;j++){
            if (board[0][j]=='O'){
                dfs(1,j,board,list);
            }
            if (board[board.length-1][j]=='O'){
                dfs(board.length-2,j,board,list);
            }
        }
        for (int i = 1;i<board.length-1;i++){
            for (int j = 1;j<board[0].length-1;j++){
                board[i][j]='X';
            }
        }
        for (int []cur :list){
            board[cur[0]][cur[1]]='O';
        }
    }

    private static void dfs(int i, int j, char[][] board,List<int []>list) {
        if (i==0||j==0||i==board.length-1||j==board[0].length-1){
            return ;
        }
        if (board[i][j]=='O'){
            board[i][j] = 'X';
            list.add(new int[]{i,j});
            dfs(i+1,j,board,list);
            dfs(i,j+1,board,list);
            dfs(i-1,j,board,list);
            dfs(i,j-1,board,list);
        }
    }
}

