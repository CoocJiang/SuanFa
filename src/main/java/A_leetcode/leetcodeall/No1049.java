package A_leetcode.leetcodeall;

public class No1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i:stones){
            sum+=i;
        }
        int near = near(stones,sum);
        return sum - near - near;
    }

    public static int near(int [] stones,int near){
        int []dp = new int [near+1];
        for(int i = 1;i<=stones.length;i++){
            for (int j = near;j>=0;j--){
                if(j - stones[i-1]>=0){
                    dp[j]=Math.max(dp[j],dp[j-stones[i-1]]+stones[i-1]);
                }
            }
        }
        return dp[near];
    }
}
