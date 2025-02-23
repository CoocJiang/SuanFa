package A_leetcode.pdd;

import java.util.Arrays;

public class No322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }


    static int [][] dp;
    public static int coinChange(int[] coins, int amout) {
        int index = 0;
        dp  = new int[coins.length+1][amout+1];
        for (int i = 0;i<coins.length+1;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        int ans = process(index,amout,coins);
        return ans==Integer.MAX_VALUE/2 ? -1:ans;
    }

    public static int process(int index,int amout,int[] coins){
        if (dp[index][amout]!=Integer.MAX_VALUE){
            return dp[index][amout];
        }
        if (index==coins.length&&amout!=0){
            return Integer.MAX_VALUE/2;
        }
        if (amout==0){
            dp[index][0] = 0;
            return 0;
        }else {
            int p1 = Integer.MAX_VALUE/2;
            for (int i = 0;amout-i*coins[index]>=0;i++){
                p1 = Math.min(i+process(index+1,amout-i*coins[index],coins),p1);
            }
            dp[index][amout] = p1;
            return p1;
        }
    }

}
