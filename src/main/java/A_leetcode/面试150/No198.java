package A_leetcode.面试150;

public class No198 {
    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    //示例 1：
    //
    //输入：[1,2,3,1]
    //输出：4
    //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    //     偷窃到的最高金额 = 1 + 3 = 4 。
    public static void main(String[] args) {
        int [] nus = {1,3,1,3,100};
        System.out.println(rob2(nus));
    }

    public static int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        return process(0,nums,dp);
    }

    public static int process(int index,int[] nums,int [] dp){
        if (index==nums.length-1){
            return nums[index];
        }
        int p1=nums[index] + (index+2<nums.length ?process(index+2,nums,dp) : 0);
        int p2 =nums[index+1]+ (index+3<nums.length ?process(index+3,nums,dp) : 0);
        dp[index] = Math.max(p1,p2);
        return dp[index];
    }
    //动态规划优化
    public static int rob2(int[] nums) {
        int max= 0;
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int [] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        for (int i=nums.length-3;i>=0;i--){
            int p1 = nums[i] + (i+2<nums.length ?  dp[i+2]:0);
            int p2 = nums[i] + (i+3<nums.length ?  dp[i+3]:0);
            int p3 = nums[i+1] + (i+3<nums.length ?  dp[i+3]:0);
            dp[i] = Math.max(Math.max(p1,p3),p2);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
