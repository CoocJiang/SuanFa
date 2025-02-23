package A_leetcode.leetcodeall;

public class NO918 {

    public int maxSubarraySumCircular(int[] nums) {
        //两种情况 就是最大的值是首尾连接的情况，第二种就是最大值不是首尾连接
        int max1 = nums[0]; //记录字数组的最小值，字数组总和减去最小值就是首尾相连的最大值
        int max2 = nums[0]; //记录字数组的最大值
        //记录总和
        int allsum = nums[0];
        int pre1= nums[0];
        int pre2 = nums[0];
        if(nums.length==1){
            return nums[0];
        }
        for(int i = 1;i<nums.length;i++){
            allsum+=nums[i];
            //先更新最大值
            if (pre1>0){
                pre1 = nums[i]+pre1;
            }else {
                pre1 = nums[i];
            }
            max2 = Math.max(pre1,max2);
            //更新最小值
            if (pre2<0){
                pre2 += nums[i];
            }else {
                pre2 = nums[i];
            }
            max1 = Math.min(pre2,max1);
        }
        //考虑到可能出现全是负数的情况，所以需要判断一下
        return allsum==max1 ? max2:Math.max(allsum-max1,max2);
    }
}
