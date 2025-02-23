package 洛谷;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

public class p2918 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String [] s = bf.readLine().split(" ");
        //公司数目
        int N = Integer.parseInt(s[0]);
        //需要的榜数
        int H = Integer.parseInt(s[1]);
        int [] cost = new int[N+1];
        int [] value = new int[N+1];
        int max = 0;
        for (int i = 1;i<=N;i++){
            s = bf.readLine().split(" ");
            value[i] = Integer.parseInt(s[0]);
            cost[i] = Integer.parseInt(s[1]);
            max = Math.max(value[i],max);
        }


        int [][]dp = new int[N+1][max+H];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0] = 0;
        //dp[i][j]代表来到第i家公司，购买价值j磅的甘草的最小消费
        for (int i = 1;i<N+1;i++){
            //来到第i家公司挑选干草
            for (int j = 0;j<dp[0].length;j++){
                //一份都不买
                dp[i][j] = dp[i-1][j];
                //能买几份买几份
                if(j-value[i]>=0&&dp[i][j-value[i]]!=Integer.MAX_VALUE){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-value[i]]+cost[i]);
                }
            }
        }
        PrintWriter out=  new PrintWriter(new OutputStreamWriter(System.out));
        int min = Integer.MAX_VALUE;
        for (int i = H;i<H+max;i++){
            min = Math.min(min,dp[N][i]);
        }
        out.print(min);
        out.flush();
        out.close();
        bf.close();
    }
}
