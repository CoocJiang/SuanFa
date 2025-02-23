package A_leetcode.leetcodeall;

import b_贪心算法实战.切金条例子;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        int[][] queries = {
                {2, 4},
                {0, 2},
                {0, 4}
        };
        for (int i : shortestDistanceAfterQueries(5, queries)) {
            System.out.println(i);
        }
    }

    static int [] queue = new int[500];
    static int left = 0;
    static int right = 0;

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] graph = new ArrayList [n];
        //记录每个点到终点的距离
        for (int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
            //每个点到下一个点都有
            graph[i].add(i+1);
        }
        //记录当前数是第几次访问
        int [] visited = new int[n];
        Arrays.fill(visited,-1);
        int [] ans = new int[queries.length];
        for (int i = 0;i<queries.length;i++){
            graph[queries[i][0]].add(queries[i][1]);
            ans[i] = bfs(i,graph,visited,n);
        }
        return ans;
    }


    //宽度优先遍历
    private static int bfs(int i, List<Integer>[] graph, int[] visited,int n) {
        left = 0;
        right = 0;
        queue[right++] = 0;
        int size = right-left;
        int step = 0;
        while (left<right){
            int cur;
            step++;
            int time = size;
            size = 0;
           for (int j = 0;j<time;j++){
               cur = queue[left++];
               for (int next : graph[cur]){
                   if (next == n-1){
                       return step;
                   }
                   if (visited[next]!=i){
                       queue[right++] = next;
                       visited[next] = i;
                       size++;
                   }
               }
           }
        }
        return n-1;
    }
}
