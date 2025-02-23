package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No740 {
    //给你一个整数数组 nums ，你可以对它进行一些操作。
    //每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
    // 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
    //开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
    public static void main(String[] args) {
        int [] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int [] num= new int [nums[nums.length-1]+1];
        for (int i=0;i<nums.length;i++){
            num[nums[i]] = num[nums[i]]+1;
        }
        int max = 0;
        int [] dp= new int [nums[nums.length-1]+1];
        for (int i = 0;i<nums.length;i++){
            dp[nums[i]] = nums[i];
            if ((nums[i]+1)<num.length&&num[nums[i]+1]!=0){
                dp[nums[i]]  = (num[nums[i]+1]*(nums[i]+1))+num[nums[i]]*nums[i];
            }
            if ((nums[i]-1)>=0&&num[nums[i]-1]!=0){
                if (   dp[nums[i]] ==nums[i]){
                    dp[nums[i]]  = (num[nums[i]-1]*(nums[i]-1))+num[nums[i]]*nums[i];
                }else {
                    dp[nums[i]] +=num[nums[i]-1]*(nums[i]-1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static int count(HashMap<Integer,Integer> map,int [] dp,int num) {
        if (dp[num]!=0&&map.get(num)==0){
            return dp[num];
        }
        dp[num] +=map.get(num);
        map.put(num,dp[num]-1);
        if (map.containsKey(num+1)&&map.get(num+1)>=1){
            dp[num]+=count(map,dp,num+1);
        }
        if (map.containsKey(num-1)&&map.get(num-1)>=1){
            dp[num]+= count(map,dp,num-1);
        }
        return dp[num];
    }
}

