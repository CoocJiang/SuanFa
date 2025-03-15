package A_leetcode.面试150;

import java.util.Arrays;

public class No322 {
//    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//    你可以认为每种硬币的数量是无限的。
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        System.out.println(coinChange3(coins,11));
    }

    static class nums{
        Integer count;
    }
    public static int coinChange(int[] coins, int amount) {
        if (coins==null){
            return -1;
        }
        long ans = pro(0,coins,amount);
        if (ans==Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans ;
    }
    public static long pro(int index,int[] coins,int rest){
        //basecase
        if (index==coins.length){
           if (rest==0){
               return 0;
           }else {
               return Integer.MAX_VALUE;
           }
        }
        //当前位置，
        long count =Integer.MAX_VALUE;
        long ans = 0;
        for (int i=0;i*coins[index]<=rest;i++){
            ans = pro(index+1,coins,rest-i*coins[index]);
            if (ans != Integer.MAX_VALUE) {
                ans = i + ans;
                count = Math.min(ans, count);
            }else {
                continue;
            }
        }
        return count;
    }
    //动态规划优化
    public static int coinChange2(int[] coins, int amount){
        int [][] dp = new int[coins.length+1][amount+1];
        for (int rest=1;rest<=amount;rest++){
            dp[coins.length][rest] = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int index =coins.length-1;index>=0;index--){
            for (int rest = 1;rest<=amount;rest++){
                int count =Integer.MAX_VALUE;
                int ans =0;
                for (int i=0;i*coins[index]<=rest;i++){
                    ans = dp[index+1][rest-i*coins[index]];
                    if (ans != Integer.MAX_VALUE) {
                        ans = i + ans;
                        count = Math.min(ans, count);
                    }else {
                        continue;
                    }
                }
                dp[index][rest]=  count;
                min = Math.min(dp[index][rest],min);
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE ? -1:dp[0][amount];
    }

    static int[][] memo = new int[10001][13];

    public static int coinChange3(int[] coins, int amount) {
        int len = coins.length;
        for (int j = 0; j <= amount; j++) {
            if (j % coins[len - 1] == 0) {
                memo[j][len - 1] = j / coins[len - 1];
            } else {
                memo[j][len - 1] = Integer.MAX_VALUE;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = 0;k * coins[i] <= j; k++) {
                    if (memo[j-k*coins[i]][i+1]!=Integer.MAX_VALUE) {
                        ans = Math.min(ans,k+memo[j-k*coins[i]][i+1]);
                    }else{
                        ans = Math.min(ans,Integer.MAX_VALUE);
                    }
                }
                memo[j][i] = ans;
            }
        }
        return memo[amount][0];
    }

    public static int process(int[] coins, int index,int target) {
        if (target==0) return 0;
        if (index==coins.length) return Integer.MAX_VALUE;
        if (memo[target][index]!=-1) return memo[target][index];
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i*coins[index]<=target;i++){
            int cnts = process(coins,index+1,target-i*coins[index]);
            if (cnts != Integer.MAX_VALUE) {
                ans = Math.min(i+cnts,ans);
            }
        }
        if (memo[target][index] ==-1) memo[target][index] = ans;
        return ans;
    }
}
