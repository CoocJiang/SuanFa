package A_leetcode.面试150;

public class No200 {
    public static void main(String[] args) {
        // 定义新的网格
        char[][] grid = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int nums = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
               nums+= process(grid,i,j);
            }
        }

     return nums;
    }

    public static int process(char[][] grid,int row,int col){
        //如果此时数组这个位置等于0说明此时这个位置已经算过，或者本来就是水
        if (grid[row][col]=='0'){
            return 0;
        }
        //如果是陆地，就要把他的四周全部变成0；
        grid[row][col] = '0';
        if (row+1< grid.length){
            process(grid,row+1,col);
        }
        if (col+1< grid[0].length){
            process(grid,row,col+1);
        }
        if (col-1>=0){
            process(grid,row,col-1);
        }
        if (row-1>=0){
            process(grid,row-1,col);
        }
        return 1;
    }

}
