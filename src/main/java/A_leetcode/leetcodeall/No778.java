package A_leetcode.leetcodeall;

import java.util.PriorityQueue;

public class No778 {

    public static void main(String[] args) {
        System.out.println(swimInWater1(new int[][]{{3, 2}, {0, 1}}));
    }
    static int [] move = new int[]{0,1,0,-1,0};

    //dijkstra
    public static int swimInWater1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]  distance= new int[n][m];
        for (int i=0;i<n;i++){
            for (int j =0;j<m;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        boolean [] [] visited = new boolean[n][m];
        PriorityQueue<int []> minheap = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        distance[0][0] = grid[0][0];
        minheap.add(new int[]{0,0,0});
        while (!minheap.isEmpty()){
            int [] cur = minheap.poll();
            int x= cur[0];
            int y= cur[1];
            int val= cur[2];
            if (x==n-1&&y==m-1){
                return val;
            }
            if (visited[x][y]){
                continue;
            }
            for (int i=1;i<move.length;i++){
                visited[x][y] = true;
                int nx = x+move[i-1];
                int ny = y+move[i];
                if (nx<n&&nx>=0&&ny<m&&ny>=0&&!visited[nx][ny]){
                    int nval = Math.max(val,grid[nx][ny]);
                    if (distance[nx][ny]>nval){
                        distance[nx][ny]=nval;
                        minheap.add(new int[]{nx,ny,nval});
                    }
                }
            }
        }
        return 0;
    }


    //Kruska算法同样也可以解决
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        unifind unifind = new unifind(m*n);
        PriorityQueue<int []> minheap = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                int id = i*m+j;
                for (int k=1;k<move.length;k++){
                    int nx = i+move[k-1];
                    int ny = j+move[k];
                    if (nx<n&&nx>=0&&ny<m&&ny>=0){
                        int desid = nx*m+ny;
                        int val = Math.max(grid[i][j],grid[nx][ny]);
                        minheap.add(new int[]{id,desid,val});
                    }
                }
            }
        }
        int max = 0;
        while (!minheap.isEmpty()){
            int [] cur = minheap.poll();
            int x= cur[0];
            int y= cur[1];
            int val = cur[2];
            if (unifind.issame(x,y)){
                continue;
            }else {
                unifind.unifind(x,y);
                max = val;
                if (unifind.issame(0,(n-1)*m+m-1)){
                    return max;
                }
            }
        }
        return max;
    }


    public static class unifind{
        int [] parent;

        public unifind(int n){
            parent = new int[n];
            for (int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int findfather(int x){
            if (parent[x]!=x){
                parent[x] = findfather(parent[x]);
            }
            return parent[x];
        }

        public void unifind(int x,int y){
            int fx = findfather(x);
            int fy = findfather(y);
            parent[fx] = fy;

        }

        public boolean issame(int x,int y){
            int fx = findfather(x);
            int fy = findfather(y);
            return fy==fx;
        }
    }

}
