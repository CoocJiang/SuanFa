package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class No210 {


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int [] indegree = new int[numCourses];
        for (int i = 0;i<prerequisites.length;i++){
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.get(start).add(end);
            indegree[end]++;
        }
        int [] queue = new int[indegree.length];
        int l = 0;
        int r = 0;
        for (int i = 0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue[r++] = i;
            }
        }
        int [] ans = new int[numCourses];
        int index = 0;
        while (l<r){
            int cur = queue[l++];
            ans[index++] = cur;
            for (Integer integer : graph.get(cur)) {
                if (--indegree[integer]==0){
                    queue[r++] = integer;
                };
            }
        }
        if (l==numCourses){
            return ans;
        }else {
            return new int[]{};
        }
    }
}
