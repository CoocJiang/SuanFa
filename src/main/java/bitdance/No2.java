package bitdance;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class No2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int times = Integer.parseInt(s[1]);
        long  [] arr = new long[n];
        long sum = 0;
        s = bf.readLine().split(" ");
        for (int i = 0;i<n;i++){
            sum+= Integer.parseInt(s[i]);
            arr[i] = sum;
        }
        for (int i = 0;i<times;i++){
            s = bf.readLine().split(" ");
            long ans = 0;
            long max = 0;
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            for (int j = l;j<=r;j++){
                ans = arr[j-1];
                max = Math.max(ans,max);
                for (int k = j;k<n;k++){
                    ans=arr[k]-arr[k-j];
                    max = Math.max(ans,max);
                }
            }
            out.println(max);
        }
        out.println();
        out.close();
    }
}
