package A_leetcode.leetcodeall;

import java.util.*;

public class No936 {
    public static void main(String[] args) {
        String stamp = "abca", target = "aabcaca";
        System.out.println(movesToStamp(stamp, target));
    }
    public static int[] movesToStamp(String stamp, String target) {
        int s =stamp.length();
        int t = target.length();
        char[] stamps = stamp.toCharArray();
        char [] targets = target.toCharArray();
        int [] degree = new int [t-s+1];
        Arrays.fill(degree,s);
        List<List<Integer>> graph = new ArrayList<>();
        //初始化邻接表
        for (int i=0;i<t;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<degree.length;i++){
            for (int j=0;j<s;j++){
                if (stamps[j]==targets[i+j]){
                    degree[i]--;
                }else {
                    graph.get(i+j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<degree.length;i++){
            if (degree[i]==0){
                queue.offer(i);
            }
        }

        boolean [] visited = new boolean[t];
        int num;
        int [] path = new int[degree.length];
        int where = 0;
        while (!queue.isEmpty()){
            num=queue.poll();
            path[where++] = num;
            for (int j=0;j<s;j++){
                if (!visited[num+j]){
                    visited[num+j] = true;
                    for (int k:graph.get(num+j)){
                        if (--degree[k]==0){
                            queue.add(k);
                        }
                    }
                }

            }
        }

        for (int i = 0; i < path.length / 2; i++) {
            int temp = path[i];
            path[i] = path[path.length - i - 1];
            path[path.length - i - 1] = temp;
        }
        return path;
    }
}
