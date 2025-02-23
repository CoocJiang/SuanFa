package A_leetcode.leetcodeall;

import java.util.*;

public class No698 {

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9},5));
    }

    static int target;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int sum = 0;
        for (int i = 0;i<n;i++){
            sum+=nums[i];
        }
        if (sum % k != 0) return false;
        target = sum / k;
        boolean ans = true;
        for (int j = n-1;j>=0;j--){
            ans = true;
            boolean [] flags = new boolean[n];
            for (int i =n-1;i>=0;i-- ){
                int cur = (j+n)%n;
                if (!flags[cur]){
                    flags[cur] = true;
                    if(!process(nums,flags,target-nums[i])){
                        ans = false;
                        break;
                    }
                }
            }
            if (ans){
                return true;
            }
        }
        return false;
    }

    private static boolean process(int[] nums, boolean[] flags,int need) {
        if (need>0){
            for (int i =nums.length-1;i>=0;i-- ){
                if (!flags[i]){
                    flags[i] = true;
                    if(process(nums,flags,need-nums[i])){
                        return true;
                    }
                    flags[i] = false;
                }
            }
            return false;
        }else return need == 0;
    }


}
