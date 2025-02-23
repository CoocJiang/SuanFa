package A_leetcode.leetcodeall;

public class No79 {


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }


    static char [] chars;
    static boolean [][] visited;
    static int [] move = new int[]{ 1,0,-1,0,1};
    static int n;
    static int m;
    public static boolean exist(char[][] board, String word) {
        chars = word.toCharArray();
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for(int row = 0;row<n;row++){
            for(int col = 0;col<m;col++){
                if(board[row][col]==chars[0]){
                    visited[row][col]=true;
                    if (process(1,board,row,col)){
                        return true;
                    }
                    visited[row][col]=false;
                }
            }
        }
        return false;
    }
    public static boolean process(int index,char [][] board,int row,int col){
        if(index==chars.length){
            return true;
        }
        //判断当前字符四周有无 我需要的index处的字符
        for(int i = 1;i<move.length;i++){
            int nrow = row+move[i-1];
            int ncol = col+move[i];
            if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&& !visited[nrow][ncol] &&board[nrow][ncol]==chars[index]){
                visited[nrow][ncol] = true;
                if(index+1<chars.length&&!process(index+1,board,nrow,ncol)){
                    visited[nrow][ncol] = false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
