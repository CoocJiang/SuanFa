package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No486 {

    static int [][] dp = new int[20][20];
    static int count;
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
            sum+=nums[i];
            dp[i][i] = nums[i];
        }
        int head = 0;
        int tail = nums.length-1;
        count = process(nums,head,tail);
        return count>=sum-count;
    }

    private int process(int[] nums, int head, int tail) {
        if (dp[head][tail]!=-1){
            return dp[head][tail];
        }
        if (head==tail){
            dp[head][tail] = nums[tail];
            return dp[head][tail];
        }else if (head+1==tail){
            return Math.max(nums[head],nums[tail]);
        }
        // 此时 1 可以选择 head 和 tail
        int p1 = nums[head]+Math.min(process(nums,head+1,tail-1),process(nums,head+2,tail));
        int p2 = nums[tail]+Math.min(process(nums,head+1,tail-1),process(nums,head,tail-2));
        dp[head][tail] = Math.max(p1,p2);
        return dp[head][tail];
    }


}
