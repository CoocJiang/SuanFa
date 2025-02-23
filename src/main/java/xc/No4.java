package xc;

import java.io.*;
import java.util.Arrays;

public class No4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int p = Integer.parseInt(s[2]);
        int [] a = new int[n];
        int [] b = new int[k];
        s =  bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s =  bf.readLine().split(" ");
        for (int i = 0;i<k;i++){
            b[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        out.println(Math.abs(p-a[0]));
        out.close();
    }
}