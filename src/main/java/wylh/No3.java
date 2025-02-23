package wylh;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class No3 {

    static int [][] nums = new int[][]{{8,4},{2,3},{5,2},{1,1}};
    static String [] values = new String[]{"ace","bre","cat","dog"};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        String col = s[0];
        String method = s[1];
        TreeMap<int[],String> treeMap;
        //总共就四种情况
        if (col.equals("sort1")){
            if (method.equals("asc")){
                 treeMap=new TreeMap<>(((o1, o2) -> o1[0]-o2[0]));

            }else {
                treeMap=new TreeMap<>(((o1, o2) -> o2[0]-o1[0]));
            }
        }else {
            if (method.equals("asc")){
                 treeMap=new TreeMap<>(((o1, o2) -> o1[1]-o2[1]));
            }else {
                 treeMap=new TreeMap<>(((o1, o2) -> o2[1]-o1[1]));
            }
        }
        for (int i = 0;i< nums.length;i++){
            treeMap.put(nums[i],values[i]);
        }
        for (Map.Entry<int[],String> entry:treeMap.entrySet()){
            out.println(entry.getValue());
        }
        out.close();
    }
}
