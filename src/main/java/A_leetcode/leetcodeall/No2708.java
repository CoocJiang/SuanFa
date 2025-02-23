package A_leetcode.leetcodeall;

public class No2708 {
    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{6,-3,-4,8,4,7,6,4,7,7,-3,-6,9}));
    }
    public static long maxStrength(int[] nums) {
        long ans = Integer.MIN_VALUE;
        for (int i = 1;i<=nums.length;i++){
            ans = Math.max(ans,process(i,nums,nums[i-1]));
        }
        return ans;
    }
    private static long process(int i, int[] nums,long sum) {
        if (i == nums.length){
            return sum;
        }else {
            long p1 = process(i+1,nums,sum*nums[i]);
            long p2 = process(i+1,nums,sum);
            return Math.max(p1,p2);
        }
    }
}
