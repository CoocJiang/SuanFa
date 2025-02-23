package A_leetcode.面试150;

import java.util.HashMap;
import java.util.HashSet;

public class No827 {

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {1,1},
                {1,0},
        };
        System.out.println(largestIsland(grid));
    }
    static int start = 2;
    static int count = 0;

    static int [] move = new int[]{1,0,-1,0,1};

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        start = 2;
        int [] map = new int[250000];
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1){
                    count = 0;
                    dfs(i,j,grid);
                    ans = Math.max(count,ans);
                    map[start++] = count;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==0){
                    int cnts = 0;
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 1;k<move.length;k++){
                        int nx = i+move[k-1];
                        int ny = j+move[k];
                        if (nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length){
                            if (!set.contains(grid[nx][ny])){
                                cnts+=map[grid[nx][ny]];
                            }
                            set.add(grid[nx][ny]);
                        }
                    }
                    ans = Math.max(ans,++cnts);
                }
            }
        }
        return ans;
    }

    public static void dfs(int i,int j,int [][]grid){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==1){
            grid[i][j] = start;
            count++;
            dfs(i+1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
            dfs(i-1,j,grid);
        }
    }
}
