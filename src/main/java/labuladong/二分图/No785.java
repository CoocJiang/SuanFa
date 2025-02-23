package labuladong.二分图;

public class No785 {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2,3}, {0, 2}, {0,1,3}, {0, 2}}));
    }
    public static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        boolean [] visited = new boolean[length];

        int [] colors = new int[length];

        boolean ans = true;

        int [] queue = new int[length*length];
        int r = 0;
        int l = 0;
        for (int i = 0;i<graph.length;i++){
            queue[r++] = i;
            while (l<r){
                int start = queue[l++];
                if (colors[start]==0){
                    visited[start] = true;
                    colors[start]=1;
                }
                for (int end:graph[start]){
                    if (!visited[end]){
                        visited[end] = true;
                        colors[end] = colors[start]== 1 ? 2:1;
                        queue[r++] = end;
                    }else {
                        if ( colors[end]==colors[start]){
                            ans = false;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
