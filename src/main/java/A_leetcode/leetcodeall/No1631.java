package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class No1631 {


    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,1,1,2,1}}));
    }
    static int [] move = new int[]{0,1,0,-1,0};
    //Dijkstra解决
    public static int minimumEffortPath1(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean [][] visited = new boolean[n][m];
        //代表去某个点的最大绝对值
        int [][] distcance = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j = 0;j<m;j++){
                distcance[i][j] = Integer.MAX_VALUE;
            }
        }
        distcance[0][0] = 0;
        PriorityQueue<int []> minheap = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        minheap.add(new int[]{0,0,0});

        while (!minheap.isEmpty()){
            int [] cur = minheap.poll();
            int x = cur[0];
            int y = cur[1];
            int val= cur[2];
            if (visited[x][y]){
                continue;
            }
            if (x==n-1&&y==m-1){
                return val;
            }
            visited[x][y] = true;
            for (int i=1;i< move.length;i++){
                int nx = x+move[i-1];
                int ny = y+move[i];
                if (nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]){
                    int newnval = Math.abs(heights[nx][ny]-heights[x][y]);
                    int nval = Math.max(val,newnval);
                    if (distcance[nx][ny]>nval){
                        distcance[nx][ny]=nval;
                        minheap.add(new int[]{nx,ny,nval});
                    }
                }
            }
        }
        return distcance[n-1][m-1];
    }

    //Kruska算法同样也可以解决
    static int [] Move = new int[]{1,0,1};
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<int []> edges = new ArrayList<>();
        unifind unifind  = new unifind(n*m);
        for (int i=0;i<n;i++){
            for (int j = 0;j<m;j++){
                int id = i*m+j;
                for (int k =1;k<Move.length;k++){
                    int desx = i+Move[k-1];
                    int desy = j+Move[k];
                    if (desx<n&&desy<m){
                        int val  = Math.abs(heights[desx][desy] - heights[i][j]);
                        edges.add(new int[]{id,desx*m+desy,val});
                    }
                }

            }
        }
        int max = 0;
        Collections.sort(edges,(o1,o2)->o1[2]-o2[2]);
        for (int []edge:edges){
            int id = edge[0];
            int desid = edge[1];
            int val = edge[2];
            if (!unifind.issame(id,desid)){
                unifind.unifind(id,desid);
                max = Math.max(val,max);
            }
            if (unifind.issame(0,((n-1)*m+m-1))){
                return max;
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
