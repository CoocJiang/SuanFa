package xc;

import java.io.*;
import java.util.*;

public class No3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int l = Integer.parseInt(s[2]);
        int [] arr = new int[n];
        s =  bf.readLine().split(" ");
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int num = 0;
        for (int i = 0;i<n;i++){
            num = Integer.parseInt(s[i]);
            arr[i] = num;
            if (map.containsKey(num)){
                map.get(num).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num,list);
            }
        }
        int min = Integer.MAX_VALUE;
        int length = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            List<Integer> values = entry.getValue();
            for (int i = 1;i<values.size();i++){
                length = Math.min(values.get(i)-values.get(i-1),length);
            }
        }
        while (k>=0){
            Map.Entry<Integer, List<Integer>> entry = map.pollFirstEntry();
            List<Integer> values = entry.getValue();
            if (k>=values.size()){
                k -=values.size();
            }else {
                if (length<l+k){
                    out.println(map.pollFirstEntry().getKey());
                }else {
                    out.println(entry.getKey());
                }
                break;
            }
        }
        out.close();
    }
}