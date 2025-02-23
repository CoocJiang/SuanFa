package redbook;

import java.io.*;
import java.util.Arrays;

public class No1 {

    static int cnts;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine().split(" ")[0]);
        String[] s = bf.readLine().split(" ");
        arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        cnts = (n+1)/2;
        Arrays.sort(arr);
        int suma = 0;
        int sumb = 0;
        int cnta = 1;
        int cntb = 0;
        suma = arr[n-1];
        for (int i = n-2;i>=0;i--){
            if (suma>sumb){
                sumb+=arr[i];
            }else {
                suma+=arr[i];
            }
        }
        out.println(Math.abs(suma-sumb));
        out.close();
    }
}
