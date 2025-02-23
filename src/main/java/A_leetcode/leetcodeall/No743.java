package A_leetcode.leetcodeall;

import java.util.*;

public class No743 {

    //Dijkstra算法
    public static int networkDelayTime(int[][] times, int n, int k) {
        //标记到某节点的最小距离
        int [] distance = new int[n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);
        //到自己的距离为0;
        distance[k] =0;
        //是否去过某节点
        boolean [] visitied = new boolean[n+1];

        List<List<int []>> graph = new ArrayList<>();
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //初始化有向图
        for (int i=0;i<times.length;i++){
            int des = times[i][1];
            int value = times[i][2];
            graph.get(times[i][0]).add(new int[]{des,value});
        }
        PriorityQueue<int []> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        //先加入自己到堆中
        heap.add(new int[]{k,0});
        while (!heap.isEmpty()){
            //弹出堆中最小的，此时最小的就是到他的距离最小，后续无需更新，设置他的vistied为true
            int [] cur = heap.poll();
            int gra = cur[0];
            if (!visitied[gra]){
                visitied[gra] = true;
                for (int [] arr:graph.get(gra)){
                    if ((!visitied[arr[0]])&&(distance[arr[0]]>(cur[1]+arr[1]))){
                        distance[arr[0]]  = cur[1]+arr[1];
                        heap.add(new int[]{arr[0],distance[arr[0]]});
                    }
                }
            }
        }
        int max = 0;
        for (int i=1;i< distance.length;i++){
            max = Math.max(distance[i],max);
        }
        return max==Integer.MAX_VALUE ? -1:max;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime1(new int[][]{{1,2,1}}, 2, 2));
    }
    public static int networkDelayTime1(int[][] times, int n, int k) {

        List<List<int []>> graph = new ArrayList<>();
        for (int i =0 ;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        int start;
        int end;
        for (int i = 0;i<times.length;i++){
            start = times[i][0];
            end = times[i][1];
            graph.get(start).add(new int[]{end,times[i][2]});
        }

        PriorityQueue<int []> heap = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        heap.add(new int[]{k,0});
        HashSet<Integer> set = new HashSet<>();
        while (!heap.isEmpty()){
            int [] cur = heap.poll();
            int now = cur[0];
            int ditance = cur[1];
            if (!set.contains(now)){
                set.add(now);
                if (set.size()==n){
                    return ditance;
                }
                for (int[] ints : graph.get(now)) {
                    heap.add(new int[]{ints[0],ditance+ints[1]});
                }
            }
        }
        return -1;
    }
}
