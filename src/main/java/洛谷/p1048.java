package 洛谷;

import java.io.*;
import java.nio.Buffer;

public class p1048 {

//    static int  [][] dp = new int[101][1001];
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
        int ans = 0;
        int [][]dp = new int[n+1][time+1];
        //当前从第一种草药开始，要或者不要
        //先填好第一种草药
        for (int i = 1;i<=n;i++){
            //来到第i种草药
            for (int j = 0;j<=time;j++){
                //如果不要当前草药
                dp[i][j] = dp[i-1][j];
                //如果要当前草药
                if (j -cost[i]>=0){
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]]+value[i],dp[i][j]);
                }
            }
        }
       PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       out.print(dp[n][time]);
       out.close();
    }
}
