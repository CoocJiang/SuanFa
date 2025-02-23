package A_leetcode.面试150;

import java.util.*;

public class No851 {
    public static void main(String[] args) {
        int [][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int [] q = {3,2,5,4,6,1,7,0};
        loudAndRich(richer,q);
    }
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i< quiet.length;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[quiet.length];
        for (int i=0;i<richer.length;i++){
            graph.get(richer[i][0]).add(richer[i][1]);
            indegree[richer[i][1]]++;
        }
        int []ans = new int[quiet.length];
        for (int i=0;i<ans.length;i++){
            ans[i] = i;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            for (int j:graph.get(num)){
                if (quiet[ans[num]]<=quiet[ans[j]]){
                    ans[j] = ans[num];
                }
                if (--indegree[j]==0){
                    queue.add(j);
                }
            }
        }
        return ans;
    }
}
