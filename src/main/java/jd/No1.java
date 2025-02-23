package jd;

import java.io.*;

public class No1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        s = bf.readLine().split(" ");
        long sum = 0;
        int cur = 0;
        long [] arr = new long[n];
        for (int i = 0;i<n;i++){
            cur = Integer.parseInt(s[i]);
            sum+=cur;
            arr[i] = sum;
        }
        long min = Long.MAX_VALUE;
        for (int i = 0;i<n-1;i++){
            long daijia = arr[i] *(arr[n-1]-arr[i]);
            min = Math.min(daijia,min);
        }
        out.println(Math.min(0,min));
        out.close();
    }
}
