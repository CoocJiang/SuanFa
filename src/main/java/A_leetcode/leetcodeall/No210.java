package A_leetcode.leetcodeall;

import java.util.*;

public class No210 {
    public static void main(String[] args) {
        int numCourse = 2;
        int [][] pre = {{1,0}};
        System.out.println(findOrder(numCourse, pre));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        //入度表
        int [] indegree= new int[numCourses];
        for (int i=0;i< prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Deque<Integer> deque = new LinkedList<>();
        int where=0;
        int [] ans = new int [numCourses];
        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            Integer first = deque.getFirst();
            ans[where++] = first;
            for (int q:list.get(first)){
                if (--indegree[q]==0){
                    deque.addLast(q);
                }
            }
            deque.removeFirst();
        }
       if (where<numCourses){
           return new int [0];
       }
       return ans;
    }
}
