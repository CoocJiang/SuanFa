package A_leetcode.leetcodeall;

public class No3127 {
    public static void main(String[] args) {
        char[][] grid = {
                {'B', 'W', 'B'},
                {'B', 'W', 'W'},
                {'B', 'W', 'B'}
        };
        System.out.println(canMakeSquare(grid));
    }
    static int [] move = new int[]{1,0,1,1};
    public static boolean canMakeSquare(char[][] grid) {
        int n = grid.length;
        int bc = 0;
        int wc = 0;
        for (int i = 0;i<n-1;i++){
            for (int j = 0;j<n-1;j++){
                bc = 0;
                wc = 0;
                if (grid[i][j]=='W'){
                    wc++;
                }else {
                    bc++;
                }
                for (int k = 1;k<move.length;k++){
                    if (grid[i+move[k-1]][j+move[k]]=='W'){
                        wc++;
                    }else {
                        bc++;
                    }
                }
                if (bc>=3||wc>=3){
                    return true;
                }
            }
        }
        return false;
    }
}
