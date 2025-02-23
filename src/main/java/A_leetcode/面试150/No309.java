package A_leetcode.面试150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class No309 {
    //309. 买卖股票的最佳时机含冷冻期
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] prices = {1,2,3,0,2};
        System.out.println(maxProfit3(prices));
    }
    public static int maxProfit2(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        int [] cop = Arrays.copyOf(prices,prices.length);
        Arrays.sort(cop);
        int [][] dp = new int [prices.length+1][cop[cop.length-1]+2];
        return process(prices,0,0,dp);
    }

    public static int process(int []prices,int index,int status,int[][]dp){
        if (index>=prices.length){
            return 0;
        }
        if (dp[index][status]!=0){
            return dp[index][status];
        }
        int p1 = 0;
        int p2 = 0;
        //判断此时状态,如果处于没卖状态
        if (status==0){
            //当前来到这个位置只有两种选择，买或者不买
            if (index<prices.length){
                //1 买
                p1 = process(prices,index+1,prices[index]+1,dp);
                //不买
                p2 = process(prices,index+1,status,dp);
            }
        }else {
            //如果处于卖出状态
            //卖
            p1 =prices[index] - status + 1 + process(prices,index+2,0,dp);
            //不卖
            p2 = process(prices,index+1,status,dp);
        }
        dp[index][status] = Math.max(p1,p2);
        return Math.max(p1,p2);
    }

    //动态规划优化
    public static int maxProfit(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        int [] cop = Arrays.copyOf(prices,prices.length);
        Arrays.sort(cop);
        int [][] dp = new int [prices.length+2][cop[cop.length-1]+2];
        for (int index = prices.length-1;index>=0;index--){
            for (int status = 0;status<dp[0].length;status++){
                int p1 = 0;
                int p2 = 0;
                //判断此时状态,如果处于没卖状态
                if (status==0){
                    //当前来到这个位置只有两种选择，买或者不买
                    if (index<prices.length){
                        //1 买
                        p1 = dp[index+1][prices[index]+1];
                        //不买
                        p2 = dp[index+1][status];
                    }
                }else {
                    //如果处于卖出状态
                    //卖
                    if (index+2<dp.length){
                        p1 =prices[index] - status + 1 + dp[index+2][0];
                    }else {
                        if (index<prices.length){
                            p1 =prices[index] - status + 1 ;
                        }
                    }
                    //不卖
                    if (index+1<prices.length) {
                        p2 = dp[index + 1][status];
                    }
                }
                dp[index][status] = Math.max(p1,p2);
            }
        }
        return dp[0][0];
    }


    //
    public static int maxProfit3(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int n= prices.length;
        int [][]f = new int[n][3];
        f[0][0]=-prices[0];
        for (int i=1;i<f.length;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1] = f[i-1][0]+prices[i];
            f[i][2] = Math.max(f[i-1][2],f[i-1][1]);
        }
        return Math.max(f[n-1][1],f[n-1][2]);

    }
}
