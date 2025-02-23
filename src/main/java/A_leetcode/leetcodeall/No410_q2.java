package A_leetcode.leetcodeall;

import java.util.*;

public class No410_q2 {

    public static void main(String[] args) {
        // 定义边信息
        int[][] edges = {
                {6, 0},
                {1, 0},
                {5, 1},
                {2, 5},
                {3, 1},
                {4, 3}
        };
        System.out.println(countGoodNodes(edges));
    }
    static int ans ;
    public static int countGoodNodes(int[][] edges) {
        ans = 0;
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int start,end;
        for (int [] cur:edges){
            start = cur[0];
            end = cur[1];
            if (graph.containsKey(start)){
                graph.get(start).add(end);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(end);
                graph.put(start,list);
            }
            if (graph.containsKey(end)){
                graph.get(end).add(start);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                graph.put(end,list);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(graph,visited,0);
        return ans;
    }

    private static int dfs(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited,int start) {
        if (!graph.containsKey(start)){
            ans++;
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sumCount = 0;
        int count = 0;
        for (int next:graph.get(start))   {
            if (!visited.contains(next)){
                visited.add(next);
                sumCount = 1 + dfs(graph,visited,next);
                count+=sumCount;
                map.put(sumCount,map.getOrDefault(sumCount,0)+1);
            }
        }
        if (map.size()==1||count==0){
            ans++;
        }
        return 1+count;
    }

//    private static int process(HashMap<Integer, List<Integer>> map,
//                               HashMap<Integer, Integer> visited,int index,ArrayList<Integer> visit) {
//        visit.add(index);
//        if (visited.containsKey(index)){
//            return visited.get(index);
//        }
//        List<Integer> list = map.get(index);
//        int count = 0;
//        HashMap<Integer,Integer> result = new HashMap<>();
//        for (int i = 0;i<list.size();i++){
//            int cur = list.get(i);
//            if (visited.containsKey(cur)) {
//                result.put(visited.get(cur), result.getOrDefault(visited.get(cur), 0) + 1);
//                count += visited.get(cur);
//            } else {
//                if (map.containsKey(cur)) {
//                    visited.put(cur, process(map, visited, cur, visit) + 1);
//                    result.put(visited.get(cur), result.getOrDefault(visited.get(cur), 0) + 1);
//                } else {
//                    result.put(1, result.getOrDefault(1, 0) + 1);
//                    visited.put(cur, 1);
//                    ans++;
//                }
//                count += visited.get(list.get(i));
//            }
//        }
//        if (result.size()==1){
//            ans++;
//        }
//        return count;
//    }
}
