package A_leetcode.leetcodeall;

public class No1493 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1, 0, 1}));
    }
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int length = 0;
        for (int i = 0;i<n;i++){
            if (nums[i]==0){
                max = Math.max(process(nums,i),max);
                length=0;
            }else {
                length++;
            }
        }
        return Math.max(length-1,max);
    }

    private static int process(int[] nums, int i) {
        int l = i-1;
        int r = i+1;
        int left = 0;
        int right = 0;
        while (l>=0&&nums[l]==1){
            l--;
            left++;
        }
        while (r<nums.length&&nums[r]==1){
            r++;
            right++;
        }
        return left+right;
    }
}
