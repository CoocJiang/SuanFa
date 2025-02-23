package mt;

public class No200 {

    static int [] distance = new int[]{1,0,-1,0,1};
    static int n,m;
    public int numIslands(char[][] grid) {
        n  =  grid.length;
        m = grid[0].length;
        int count = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '2';
        int newx = 0;
        int newy = 0;
        for (int k = 1;k<distance.length;k++){
            newx = i+distance[k-1];
            newy = j+distance[k];
            if (newx>=0&&newx<n&&newy>=0&&newy<m&&grid[newx][newy]=='1'){
                dfs(newx,newy,grid);
            }
        }
    }
}
