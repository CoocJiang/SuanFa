package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        permute(nums);
        for (List<Integer> list:res){
            for (int i:list){
                System.out.println(i);
            }
            System.out.println();
        }
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        res.clear();
        process(nums,0);
        return res;
    }
    public static void process(int [] nums,int index){
        if (index == nums.length-1){
            List<Integer> ans = new ArrayList<>();
            for (int i :nums){
                ans.add(i);
            }
            res.add(ans);
            return;
        }
        //当前来到index位置，所有数字都做为index位置的数去递归
        for (int j = index;j<nums.length;j++){
            swap(nums,index,j);
            process(nums,index+1);
            swap(nums,j,index);
        }
    }
    public static void swap(int []nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
