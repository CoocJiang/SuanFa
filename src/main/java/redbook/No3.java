package redbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n  = Integer.parseInt(s[1]);
        int [] arr = new int[n];
        s = bf.readLine().split(" ");
        for (int i =0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int mid = n/2;
        int ans = 0;
        for (int i = 0;i<4;i++){
            int index = Math.min(n-1,mid+i);
            long re = 0;
            for (int j = 0;j<index;j++){
                re+= arr[index]-arr[j];
            }
            for (int j = index+1;j<n;j++){
                re+= arr[j]-arr[index];
            }
            if (re<min){
                min = re;
                ans = arr[index];
            }
        }
        out.println(ans);
        out.close();
    }
}
