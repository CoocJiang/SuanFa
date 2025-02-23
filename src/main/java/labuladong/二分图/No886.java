package labuladong.二分图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No886 {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6},
                {6, 7},
                {8, 9},
                {7, 8}
        };
        System.out.println(possibleBipartition(10, array));
    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {

        boolean [] visited = new boolean[n+1];

        int [] colors = new int[n+1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0;i<dislikes.length;i++){
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        boolean ans = true;

        int [] queue = new int[n];
        int r = 0;
        int l = 0;
        for (int i = 1;i<graph.size();i++){
            queue[r++] = i;
            while (l<r){
                int start = queue[l++];
                if (colors[start]==0){
                    visited[start] = true;
                    colors[start]=1;
                }
                for (int end:graph.get(start)){
                    if (!visited[end]){
                        visited[end] = true;
                        colors[end] = colors[start]== 1 ? 2:1;
                        queue[r++] = end;
                    }else {
                        if ( colors[end]==colors[start]){
                            ans = false;
                            break;
                        }
                    }
                }
            }
            l = 0;
            r = 0;
        }
        return ans;
    }
}
