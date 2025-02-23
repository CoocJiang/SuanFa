package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No714 {
    public static void main(String[] args) {
        String s = "qq";
        
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
    static int [][] dp;
    public static int maxProfit(int[] prices, int fee) {
        //当前来到 index位置，
        dp = new int[2][prices.length+1];
        for (int i = prices.length-1;i>=0;i--){
            dp[0][i] = Math.max(dp[1][i+1]-prices[i],dp[0][i+1]);
            dp[1][i] = Math.max(dp[0][i+1]+prices[i]-fee,dp[1][i+1]);
        }
        return dp[0][0];
    }
    public static int process(int fee,int index,int state,int []prices){
        if(index==prices.length){
            return 0;
        }
        if(dp[state][index]!=Integer.MIN_VALUE){
            return dp[state][index];
        }
        int ans;
        int p1 = 0;
        int p2 = 0;
        if(state==0){
            p1 = process(fee,index+1,1,prices)-prices[index];
            p2 = process(fee,index+1,0,prices);
        }else if(state==1){
            p1 = process(fee,index+1,0,prices)+prices[index]-fee;
            p2 = process(fee,index+1,1,prices);
        }
        ans = Math.max(p1,p2);
        dp[state][index] = ans;
        return ans;
    }
}
