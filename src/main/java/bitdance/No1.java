package bitdance;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        List<List<Integer>> go = new ArrayList<>(n+1);
        List<List<Integer>> to = new ArrayList<>(n+1);
        for (int i = 0;i<=n;i++){
            go.add(new ArrayList<>());
            to.add(new ArrayList<>());
        }
        int [][] edges = new int[n-1][2];
        for (int i = 0;i<n-1;i++){
            s = bf.readLine().split(" ");
            int nums1 = Integer.parseInt(s[0]);
            int nums2 = Integer.parseInt(s[1]);
            edges[i][0] = nums1;
            edges[i][1] = nums2;
            go.get(nums1).add(nums2);
            go.get(nums2).add(nums1);
        }
        int cnts = 0;
        for (int i = 0;i<edges.length;i++){
            List<Integer> list = go.get(edges[i][1]);
            Integer cur = edges[0][0];
            List<Integer> now = go.get(cur);
            for (Integer end:list){
                if (end!=cur&&!now.contains(end)&&!to.get(cur).contains(end)){
                    to.get(cur).add(end);
                    to.get(end).add(cur);
                    cnts++;
                }
            }
            list = go.get(edges[i][0]);
            cur = edges[i][1];
            now = go.get(cur);
            for (Integer end:list){
                if (end!=cur&&!now.contains(end)&&!to.get(cur).contains(end)){
                    to.get(cur).add(end);
                    to.get(end).add(cur);
                    cnts++;
                }
            }
        }
        out.println(cnts);
        out.close();
    }
}
