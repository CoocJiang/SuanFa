package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No322 {

    static int [] dp;
    public int coinChange(int[] coins, int amount) {
        //basecase
        dp = new int[amount+1];
        Arrays.fill(dp,-2);
        return process(coins,amount);
    }

    public static int process(int[] coins, int amount){
        if(amount<0){
            return -1;
        }else if(amount==0){
            return 0;
        }else{
            if (dp[amount]!=-2){
                return dp[amount];
            }
            int cnts = Integer.MAX_VALUE;
            for(int c:coins){
                int num = process(coins,amount-c);
                if(num!=-1){
                    cnts = Math.min(cnts,num+1);
                }
            }
            dp[amount] = cnts == Integer.MAX_VALUE ? -1:cnts;
            return dp[amount];
        }
    }
}
