package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No797 {

    public static void main(String[] args) {
        allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {},
        });
    }

    static List<List<Integer>> res;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        int dest = graph.length - 1;
        getPath(graph, 0, dest, new LinkedList<>());
        return res;
    }

    private static void getPath(int[][] graph, int src, int dest, LinkedList<Integer> onPath) {
        if (src == dest) {
            onPath.add(dest);
            res.add(new ArrayList<>(onPath));
            onPath.removeLast();
            return;
        }
        onPath.add(src);
        for (int cur : graph[src]) {
            getPath(graph, cur, dest, onPath);
        }
        onPath.removeLast();
    }
}
