package pdd;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int times = Integer.parseInt(s[1]);
        HashMap<Integer,Integer> minmap = new HashMap<>();
        HashMap<Integer,Integer> maxmap = new HashMap<>();
        s = bf.readLine().split(" ");
        int [] arr = new int[n];
        for (int i = 0;i<n;i++){
            int num = Integer.parseInt(s[i]);
            arr[i] = num;
            minmap.put(num,Math.min(minmap.getOrDefault(num,Integer.MAX_VALUE),i));
            maxmap.put(num,Math.max(maxmap.getOrDefault(num,Integer.MIN_VALUE),i));
        }
        for (int i= 0;i<times;i++){
            s = bf.readLine().split(" ");
            if (s.length<2){
                //代表询问
                int maxlength = 0;
                for (Map.Entry<Integer,Integer> entry:minmap.entrySet()){
                    int key = entry.getKey();
                    if (!maxmap.containsKey(key)){
                        continue;
                    }
                    int maxval = maxmap.get(key);
                    if (entry.getValue()<maxval){
                        maxlength = Math.max(maxlength,maxval-entry.getValue());
                    }
                }
                out.println(maxlength);
            }else {
                //代表操作
                int index = Integer.parseInt(s[1])-1;
                int newnum = Integer.parseInt(s[2]);
                int num = arr[index];
                if (minmap.containsKey(num)&&minmap.get(num)==index){
                    minmap.remove(num);
                }
                if (maxmap.containsKey(num)&&maxmap.get(num)==index){
                    maxmap.remove(num);
                }
                arr[index] = newnum;
                minmap.put(newnum,Math.min(minmap.getOrDefault(newnum,Integer.MAX_VALUE),index));
                maxmap.put(newnum,Math.max(maxmap.getOrDefault(newnum,Integer.MIN_VALUE),index));
            }
        }
        out.close();
    }
}
