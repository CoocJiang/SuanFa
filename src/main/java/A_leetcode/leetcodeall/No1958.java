package A_leetcode.leetcodeall;

public class No1958 {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'B', '.', '.', 'W', '.', '.', '.'},
                {'.', '.', 'W', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'B', 'W', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'W', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'B'}
        };
        System.out.println(checkMove(board, 4, 4, 'W'));
    }
    static char fancolor ;

    static  int[] stepx = new int[]{1,1,1,0,0,-1,-1,-1};

    static  int[] stepy = new int[]{1,0,-1,1,-1,0,-1,1};


    static int n;
    static int m;
    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
         n = board.length;
         m = board[0].length;
        fancolor = getcolor(color);
       for (int i = 0;i<stepx.length;i++){
           if (check(board,rMove,cMove,i,color)) return true;
       }
        return false;
    }
    static boolean check(char [][] board,int rMove,int cMove,int k,char color){
        //判断上
        int r = rMove+stepx[k];
        int l = cMove+stepy[k];
        while (r>=0&&l>=0&&r<n&&l<m&&board[r][l]==fancolor){
            r+=stepx[k];
            l+=stepy[k];
        }
        if ((r!=rMove+stepx[k]||l!=cMove+stepy[k])&&r>=0&&l>=0&&r<n&&l<m&&board[r][l]==color){
            return true;
        }
        return false;
    }
    public static char getcolor(char color){
        if (color=='W'){
            return 'B';
        }else {
            return 'W';
        }
    }
}
