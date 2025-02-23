package A_leetcode.leetcodeall;

public class No198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prepre = nums[0];
        int pre = Math.max(nums[0],nums[1]);
        int cur = Math.max(pre,prepre);
        for(int i = 2;i<n;i++){
            cur = Math.max(prepre+nums[i],pre);
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
