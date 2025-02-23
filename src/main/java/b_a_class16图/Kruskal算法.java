package b_a_class16图;

import java.io.*;
import java.util.*;

public class Kruskal算法 {

    public static class unifind{

        int [] farther;
        int [] size;
        //用来扁平化的辅助数组
        int [] stack;
        public unifind(int s){
            farther = new int [s+1];
            size = new int [s+1];
            stack = new int [s+1];
            for (int i = 0;i<=s;i++){
                farther[i] = i;
                size[i] = 1;
            }
        }

        public boolean issameset(int a,int b){
            if ( findfarther(a)==findfarther(b)){
                return true;
            }
            return false;
        }


        public  int find(int i) {
            // 沿途收集了几个点
            int size = 0;
            while (i != farther[i]) {
                stack[size++] = i;
                i = farther[i];
            }
            // 沿途节点收集好了，i已经跳到代表节点了
            while (size > 0) {
                farther[stack[--size]] = i;
            }
            return i;
        }

        //不适用辅助数组使用递归也可以实现
        public int findfarther(int a){
            if (farther[a]!=a){
                farther[a] = findfarther(farther[a]);
            }
            return farther[a];
        }

        public void union(int a,int b){
            int f1 = findfarther(a);
            int f2 = findfarther(b);
            if (f1!=f2){
                if (size[f1]>size[f2]){
                    farther[f2] = f1;
                    size[f1]+=size[f2];
                }else {
                    farther[f1] = f2;
                    size[f2]+=size[f1];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int [][] edges = new int[m][3];
        for (int i=0;i<m;i++){
            s = bf.readLine().split(" ");
            edges[i][0] = Integer.parseInt(s[0]);
            edges[i][1] = Integer.parseInt(s[1]);
            edges[i][2] = Integer.parseInt(s[2]);
        }
        unifind unifind = new unifind(n);
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int length = 0;
        int size=1;
        for (int[] edge:edges){
            //如果不在一个并查集内
            if (unifind.find(edge[0])!=unifind.find(edge[1])){
                size++;
                length+=edge[2];
                unifind.union(edge[0],edge[1]);
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            if (size!=n){
                out.print("orz");
            }else {
                out.print(length);
            }
        out.flush();
        out.close();
    }


    //最小生成树算法Prim算法
    public static void main2(String[] args) throws IOException {
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
