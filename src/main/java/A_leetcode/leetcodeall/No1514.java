package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class No1514 {
    public static class Unifind{
        int [] f;
        int [] size;

        public Unifind(int num) {
            f = new int[num];
            size = new int[num];
            for (int i = 0;i<num;i++){
                f[i] = i;
                size[i] =1;
            }
        }

        int getf(int i){
            if (f[i]!=i){
                f[i] = getf(i);
            }
            return f[i];
        }

        public void union(int a,int b){
            if (size[a]>=size[b]){
                f[b] = a;
                size[a]+=size[b];
            }else {
                f[a] = b;
                size[b]+=size[a];
            }
        }

        boolean isUnion(int a,int b){
            int af = getf(a);
            int bf = getf(b);
            return af == bf;
        }
    }

    public static class Road{
        int addr;
        double quan;

        public Road(int addr, double quan) {
            this.addr = addr;
            this.quan = quan;
        }
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

       List<List<Road>> graph = new ArrayList<>();
       for (int i = 0;i<n;i++){
           graph.add(new ArrayList<>());
       }
       for (int i = 0;i<edges.length;i++){
           graph.get(edges[i][0]).add(new Road(edges[i][1],succProb[i]));
           graph.get(edges[i][1]).add(new Road(edges[i][0],succProb[i]));
       }
       PriorityQueue<Road> heap = new PriorityQueue<>(((o1, o2) ->Double.compare(o2.quan,o1.quan)));
       heap.add(new Road(start_node,1));
        HashSet<Integer> set = new HashSet<>();
       double [] visited = new double[n];
       while (!heap.isEmpty()){
           Road cur = heap.poll();
           double gailv = cur.quan;
           if (!set.contains(cur.addr)){
               set.add(cur.addr);
               if (set.contains(end_node)){
                   return gailv;
               }
               for (Road road:graph.get(cur.addr)){
                   road.quan=gailv*road.quan;
                   heap.add(road);
               }
           }
       }
       return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }
}
