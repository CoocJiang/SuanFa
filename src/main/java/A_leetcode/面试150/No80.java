package A_leetcode.面试150;

import java.util.Arrays;

public class No80 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,1,1,2,2,3};//{1,1,2,2,3}
        System.out.println(removeDuplicates(nums));
    }
    public  static  int removeDuplicates(int[] nums) {
        int ans = 0;
        int k =2;
        for (int x:nums){
            if(ans<k){
                nums[ans] = x;
                ans++;
            }else if(nums[ans-k] != x){
                nums[ans] =x ;
                ans++;
            }
        }
        return ans;
    }
}
