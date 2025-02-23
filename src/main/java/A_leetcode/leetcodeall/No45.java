package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.Map;

public class No45 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length<1){
            return 0;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        int cnts = 1;
        int ans = 0;
        for (int i = 1;i<nums.length;i++){
            if (pre+1==nums[i]){
               cnts++;
               ans = Math.max(ans,cnts);
            }else if (pre==nums[i]){
               continue;
            }else {
                cnts = 1;
            }
            pre = nums[i];
        }
        return ans;
    }
}
