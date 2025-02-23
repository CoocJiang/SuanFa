package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No1466 {


    public static void main(String[] args) {
        // 给定的边连接关系
        int[][] edges = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };
        System.out.println(minReorder(6, edges));
    }

    static int ans;
    public static int minReorder(int n, int[][] connections) {
        boolean [] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<n-1;i++){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
            graph.get(to).add(-from);
        }
        ans = 0;
        dfs(visited,0,graph);
        return ans;
    }


    public static void dfs(boolean []visited,int num,List<List<Integer>> graph ){
        visited[num]  = true;
        for (Integer neighbor:graph.get(num)){
            if (!visited[Math.abs(neighbor)]) {
                // 这里就体现出来有向的特性了,我们这个def方法,是从城市0的方向往外走的,因为整个结构是树(哪怕是多叉树,也不会有环的存在),因此从任意一个城市到达另一个城市,经过的城市是唯一的
                // ,如果neighbor>0,就说过没办法绕过其他城市抵达目标城市,必须要改路,因此count++
                if (neighbor > 0) {
                    // 需要变更方向的路线数增加
                    ans++;
                }
                // 继续深度优先搜索邻居节点
                dfs(visited, Math.abs(neighbor), graph);
            }
        }
    }
}
