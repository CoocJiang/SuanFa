package Labuladon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class No787 {
    public static void main(String[] args) {
        int n = 5;  // 城市数量
        int[][] flights = {
                {0, 1, 5},  // 从城市0到城市1，费用为5
                {1, 2, 5},  // 从城市1到城市2，费用为5
                {0, 3, 2},  // 从城市0到城市3，费用为2
                {3, 1, 2},  // 从城市3到城市1，费用为2
                {1, 4, 1},  // 从城市1到城市4，费用为1
                {4, 2, 1}   // 从城市4到城市2，费用为1
        };

        int src = 0;  // 出发城市
        int dst = 2;  // 目的城市
        int k = 2;

        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int []>> graph = new ArrayList<>();
        for (int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int start = 0;
        int end = 0;
        int price = 0;
        for (int i = 0;i<flights.length;i++){
            start = flights[i][0];
            end = flights[i][1];
            price = flights[i][2];
            graph.get(end).add(new int[]{start,price,0});
        }
        PriorityQueue<int []> heap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        heap.addAll(graph.get(dst));
        while (!heap.isEmpty()){
            int [] cur = heap.poll();
            price = cur[1];
            start = cur[0];
            int time = cur[2]+1;
            if (start == src){
                return price;
            }else if (time<=k){
                for (int [] add : graph.get(start)){
                    heap.add(new int[]{add[0],add[1]+price,time});
                }
            }
        }
        return -1;
    }
}
