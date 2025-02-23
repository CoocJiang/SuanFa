package A_leetcode.leetcodeall;

public class No803 {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int [] result = new int[grid.length];
        int start  = 0;
        for (int []cur:hits){
            result[start++] = process(cur[0],cur[1],grid);
        }
        return result;
    }

    private int process(int row, int col, int[][] grid) {
        if (row>=0&&row<grid.length&&col<grid[0].length&&col>=0){
            grid[row][col] = 0;
            int p1 = process2(row+1,col,grid);
            int p2 = process2(row+1,col,grid);
            int p3 = process2(row+1,col,grid);
            int p4 = process2(row+1,col,grid);
            return p1+p2+p3+p4;
        }else {
            return 0;
        }
    }

    private int process2(int row, int col, int[][] grid) {
        return 0;
    }


}
