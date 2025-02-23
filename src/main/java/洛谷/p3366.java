package 洛谷;

import java.io.*;
import java.util.*;

public class p3366 {
    //最小生成树算法Prim算法
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int [][] input = new int [m][3];
        HashSet<Integer> set= new HashSet<>();
        PriorityQueue<int []> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        List<List<int []>> graph= new ArrayList<>();
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            s = bf.readLine().split(" ");
            graph.get(Integer.parseInt(s[0])).add(new int[]{Integer.parseInt(s[1]), Integer.parseInt(s[2])});
            graph.get(Integer.parseInt(s[1])).add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[2])});
        }
        int length = 0;
        set.add(1);
        heap.addAll(graph.get(1));
        int count = 1;
        while (!heap.isEmpty()&&count<n){
            int[] poll = heap.poll();
            if (!set.contains(poll[0])){
                set.add(poll[0]);
                length+=poll[1];
                count++;
                for (int [] edge:graph.get(poll[0])){
                    heap.add(edge);
                }
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        if (count==n){
            out.print(length);
        }else {
            out.print("orz");
        }
        out.flush();
        out.close();
    }
}
