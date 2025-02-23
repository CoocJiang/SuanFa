package A_leetcode.leetcodeall;

public class No416 {


    int  [][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if((sum&1)==1){
            return false;
        }else{
            int target = sum>>1;
            dp = new int[nums.length][target];
            for (int i = 0;i<nums.length;i++){
                dp[i][target]=2;
            }
            return process(0,nums,0,target)==2;
        }
    }

    private int process(int i, int[] nums,int sum,int t) {
        if (sum>t||i>=nums.length){
            return 1;
        }else {
            if (dp[i][sum]!=0){
                return dp[i][sum];
            }
            int p1 = process(i+1,nums,sum+nums[i],t);
            int p2 = process(i+1,nums,sum,t);

            if (p1==2||p2==2){
                dp[i][sum]=2;
            }else {
                dp[i][sum]=1;
            }
            return dp[i][sum];
        }
    }


}
