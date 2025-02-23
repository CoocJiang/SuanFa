package A_leetcode.面试150;

import java.util.*;

public class No15 {
    //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    // 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    //你返回所有和为 0 且不重复的三元组。
    //注意：答案中不可以包含重复的三元组。
    public static void main(String[] args) {
        int [] nums = {0,0,0};
        for (List<Integer> sublist : threeSum(nums)) {
            for (Integer num : sublist) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i-1>=0&&nums[i-1] == nums[i]){
                continue;
            }
          list.addAll(twoSum(nums,nums[i],i));
        }
        return list;
    }
    public static List<List<Integer>> twoSum(int[] nums, int num, int index) {
        int l = index + 1;
        int r = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while (l < r) {
            if (nums[l] + nums[r] == -num) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[index]);
                list1.add(nums[l]);
                list1.add(nums[r]);
                list.add(list1);
                while (l<r&&nums[l+1] ==nums[l]){
                    l++;
                }
                while(r>l&&nums[r-1] ==nums[r]) r--;
                l++;
                r--;
            } else if (nums[l] + nums[r] < -num) {
                l++;
            } else {
                r--;
            }
        }
        return list;
    }

}
