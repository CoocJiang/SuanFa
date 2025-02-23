package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;

public class No992 {

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    static int [] arr =new int[20001];
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return process(nums,k) - process(nums,k-1);
    }

    //process统计nums数组中子数组中数字数目<k的字数组个数
    private static int process(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        Arrays.fill(arr,0);
        int debt = 0;
        while (r<nums.length){
            if(++arr[nums[r]]==1){
                debt++;
                while (debt>k){
                    if (--arr[nums[l]]==0){
                        debt--;
                    }
                    l++;
                }
            }
            //代表以r结尾符合条件的字数组（数字种类小于k）
            ans+=r-l+1;
            r++;
        }
        return ans;
    }
}
