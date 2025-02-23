package 洛谷;

import java.io.*;

public class p1616 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        //总时间
        int time = Integer.parseInt(s[0]);
        //种类
        int n = Integer.parseInt(s[1]);
        int [] cost = new int[n+1];
        int [] value = new int[n+1];
        for (int i = 1;i<n+1;i++){
            s = bf.readLine().split(" ");
            cost[i] = Integer.parseInt(s[0]);
            value[i] = Integer.parseInt(s[1]);
        }
        long []dp = new long[time+1];
        //当前从第一种草药开始，要或者不要
        //先填好第一种草药
        for (int i = 1;i<=n;i++){
            //来到第i种草药
            for (int j = cost[i];j<=time;j++){
                //如果要当前草药
                dp[j] = Math.max(dp[j-cost[i]]+value[i],dp[j]);
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(dp[time]);
        out.flush();
        out.close();
        bf.close();
    }
}
