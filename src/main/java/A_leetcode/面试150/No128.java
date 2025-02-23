package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No128 {
    public static void main(String[] args) {
        int [] nums = {1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int count =1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]-1==nums[i-1]){
                count++;
            } else if (nums[i]==nums[i-1]) {
                continue;
            } else {
                max=Math.max(count,max);
                count=1;
            }
        }
        max=Math.max(count,max);
        return max;
    }
}
