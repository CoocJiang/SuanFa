package A_leetcode.Leetcode.msb算法.并查集;

public class 岛问题 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0}
        };
        System.out.println(Island(grid));

    }
    public  static int Island(int[][] board){
        int island = 0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==1){
                    island++;
                    infect(board,i,j);
                }
            }
        }
        return  island;
    }


    public static void infect(int board[][],int i,int j){
        if ( board[i][j] == 2||board[i][j]==0){
            return;
        }
        board[i][j] = 2;
        if (j>=1){
            infect(board,i,j-1);
        }
        if (j<board[0].length-1){
            infect(board,i,j+1);
        }
        if (i>=1){
            infect(board,i-1,j);
        }
        if (i<board.length-1){
            infect(board,i+1,j);
        }
    }

}
