package A_leetcode.leetcodeall;

public class No152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }


    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int premin = nums[0];
        int premax = nums[0];
        for (int i = 1;i<nums.length;i++){
            int curmin = Math.min(nums[i],Math.min(premax*nums[i],premin*nums[i]));
            int curmax = Math.max(nums[i],Math.max(premax*nums[i],premin*nums[i]));
            premax = curmax;
            premin = curmin;
            ans = Math.max(premax,ans);
        }
        return ans;
    }

}
