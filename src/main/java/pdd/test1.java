package pdd;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class test1 {

    static char[] chars;
    static int all;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        all = Integer.parseInt(s[0]);
        int [] arr = new int[all];
        int [] brr = new int[all];
        String str = bf.readLine();
        chars = str.toCharArray();

        HashMap<Integer,Integer> mapA = new HashMap<>();
        HashMap<Integer,Integer> mapB = new HashMap<>();
        if (chars[0]=='A'){
            arr[0] = 1;
            mapA.put(1,0);
            brr[0] = -1;
            mapB.put(-1,0);
        }else {
            arr[0] = -1;
            mapA.put(-1,0);
            brr[0] = 1;
            mapB.put(1,0);
        }
        for (int i = 1;i<all;i++){
            arr[i] = arr[i-1];
            brr[i] = brr[i-1];
            if (chars[i]=='A'){
                arr[i]++;
                brr[i]--;
            }else {
                brr[i]++;
                arr[i]--;
            }
            mapA.put(arr[i],Math.min(mapA.getOrDefault(arr[i],Integer.MAX_VALUE),i));
            mapB.put(brr[i],Math.min(mapB.getOrDefault(brr[i],Integer.MAX_VALUE),i));
        }
        int max = 0;
        for (int i = all-1;i-max>=0;i--){
            int cha = arr[i];
            if (mapA.containsKey(cha)){
                max = Math.max(max,i-mapB.get(-cha));
            }
        }
        out.println(max);
        out.close();
    }




}
