package 洛谷;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class p1776 {


    public static int MAXN = 1001;
    static int[] cost = new int[MAXN];
    static int[] val = new int[MAXN];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int num = 1;
        for (int i = 1;i<=n;i++){
            s = bf.readLine().split(" ");
            int value = Integer.parseInt(s[0]);
            int cos = Integer.parseInt(s[1]);
            int cnt = Integer.parseInt(s[2]);
            val[num] = value;
            cost[num++] = cos;
            cnt--;
            for (int k = 2;cnt>=k;k=k*2){
                val[num] = k*value;
                cost[num++] = k*cos;
                cnt-=k;
            }
            if (cnt!=0){
                val[num] = value*cnt;
                cost[num++] = cos*cnt;
            }
        }
        int []dp = new int[m+1];
        for (int i = 1;i<num;i++){
            for (int j = m;j>=0;j--){
                if (j-cost[i]>=0){
                    dp[j] = Math.max(dp[j],dp[j-cost[i]]+val[i]);
                }
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(dp[m]);
        out.close();
    }
}
