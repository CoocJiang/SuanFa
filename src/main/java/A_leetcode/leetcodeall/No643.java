package A_leetcode.leetcodeall;

public class No643 {


    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int right = k-1;
        double avl = 0;
        int sum = 0;
        for (int i = 0;i<k;i++){
            sum+=nums[i];
        }
        int maxsum =sum;
        right++;
        while (right<nums.length){
            maxsum = Math.max(maxsum,sum-nums[right-k]+nums[right]);
            sum = sum-nums[right-k]+nums[right];
            right++;
        }
        return maxsum*1.0/k;
    }
}
