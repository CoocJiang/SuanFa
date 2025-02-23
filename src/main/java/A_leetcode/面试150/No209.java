package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No209 {
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //
    //找出该数组中满足其总和大于等于 target 的长度最小的 连续
    //子数组
    // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(7,nums));
    }

    public  static int minSubArrayLen(int target, int[] nums) {
        List<Integer> list =new ArrayList<>();
        int sum = 0;
        int minsize = nums.length;
        for (int i=0;i<nums.length;i++){
            int cur = nums[i];
            list.add(nums[i]);
            sum+=nums[i];
            while (sum>=target){
               minsize = Math.min(minsize,list.size());
               sum-=list.get(0);
               if (sum<target){
                   sum+=list.get(0);
                   break;
               }else {
                   list.remove(0);
                   minsize = Math.min(minsize,list.size());
               }
            }
        }
        if (sum<target){
            return 0;
        }
        return minsize;
    }


    public  static int minSubArrayLen2(int target, int[] nums) {
        int Left =0,Right=0,Sum = 0;
        int minsize = nums.length;
        boolean flag=false;
        for (int i=0;i<nums.length;i++){
            Right = i;
            Sum += nums[i];
            while (Sum>=target){
                minsize = Math.min(minsize,Right-Left+1);
                flag = true;
                Sum-=nums[Left];
                Left++;
            }
        }
        if (!flag){
            return 0;
        }
        return minsize;
    }


}
