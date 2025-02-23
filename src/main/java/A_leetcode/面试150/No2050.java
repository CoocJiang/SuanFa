package A_leetcode.面试150;

import java.util.*;

public class No2050 {

    public static void main(String[] args) {
        int [][] a= {{1,7},{1,4},{1,3},{2,3},{4,3},{5,3},{7,3},{7,6}};
        int [] b ={6,5,1,8,2,9,4};
        System.out.println(minimumTime(b.length+1,a, b));
    }

    public  static int minimumTime1(int n, int[][] relations, int[] time) {
        //一门课入度为0说明可以开始了
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<time.length;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[time.length];
        for (int i=0;i<relations.length;i++){
            graph.get(relations[i][0]-1).add(relations[i][1]-1);
            indegree[relations[i][1]-1]++;
        }
        int mounth=0;
        PriorityQueue<Integer> queue =  new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return time[o1]-time[o2];
            }
        });
        for (int i=0;i<indegree.length;i++){
           if (indegree[i]==0){
               queue.offer(i);
           }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            mounth+=time[num];
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                time[iterator.next()] -=time[num];
            }
            time[num] = 0;
            for (int j:graph.get(num)){
                if (--indegree[j]==0){
                    queue.offer(j);
                }
            }
        }
        return  mounth;
    }

    //更优的解法
    public  static int minimumTime(int n, int[][] relations, int[] time) {
        //一门课入度为0说明可以开始了
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<time.length;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[time.length];
        for (int i=0;i<relations.length;i++){
            graph.get(relations[i][0]-1).add(relations[i][1]-1);
            indegree[relations[i][1]-1]++;
        }
        int mounth=0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }
        int [] ans = new int [time.length];
        while (!queue.isEmpty()){
            int num = queue.poll();
            ans[num] = ans[num]+time[num];
            mounth = Math.max(ans[num],mounth);
            for (int j:graph.get(num)){
                --indegree[j];
                ans[j] = Math.max(ans[j],ans[num]);
                if (indegree[j]==0){
                    queue.offer(j);
                }
            }
        }
        return  mounth;
    }
}
