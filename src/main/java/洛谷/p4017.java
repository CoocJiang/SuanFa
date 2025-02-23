package 洛谷;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p4017 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int  n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int [] indgee = new int [n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        //读入数据的同时，初始化indegree和图
        for (int i=0;i<m;i++){
            int q;
            int w;
            split = bf.readLine().split(" ");
            q = Integer.parseInt(split[0]);
            w = Integer.parseInt(split[1]);
            indgee[w]++;
            graph.get(q).add(w);
        }
        int [] length = new int [n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;i<indgee.length;i++){
            if (indgee[i]==0){
                queue.add(i);
                length[i] = 1;
            }
        }
        int ans = 0;
        int num;
        while (!queue.isEmpty()){
            num = queue.poll();
            if (graph.get(num).isEmpty()){
                ans+=length[num];
            }
            for (int i:graph.get(num)){
                length[i] = length[i]+length[num];
                if (--indgee[i]==0){
                    queue.offer(i);
                }
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(ans%80112002);
        out.flush();
        out.close();
    }

}
