package A_leetcode.leetcodeall;

import java.util.*;

public class NO90 {

    public static void main(String[] args) {
        int [] nums = {1,2,2};
        for (List<Integer> list:subsetsWithDup1(nums)){
            for (int i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    static HashSet<List<Integer>> result;

    static List<List<Integer>> res;
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        process2(nums,0,new int[nums.length],0);
        return res;
    }


    public static void process(int [] nums,int index,List<Integer> ans){
        if (index==nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        //要当前元素，或者不要
        ans.add(nums[index]);
        process(nums,index+1,ans);
        ans.remove(ans.size()-1);
        process(nums,index+1,ans);
    }

    public static void process1(int [] nums,int index,List<Integer> ans){
        //basecase
        if (nums.length==index){
            result.add(ans);
            return;
        }
        int j=index+1;
        while (j<nums.length&&nums[index]==nums[j]){
            j++;
        }
        process1(nums,index+1,new ArrayList<>(ans));

        for (;index<j;index++){
            ans.add(nums[index]);
            process1(nums,j,new ArrayList<>(ans));
        }
    }

    //打败百分之百
    public static void process2(int [] nums,int index,int [] ans,int size){
        //basecase
        if (nums.length==index){
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                list.add(ans[i]);
            }
            res.add(list);
            return;
        }
        int j=index+1;
        while (j<nums.length&&nums[index]==nums[j]){
            j++;
        }
        //当前位置不要
        process2(nums,j,ans,size);
        //当前位置要
        for (;index<j;index++){
            ans[size++] = nums[index];
            process2(nums,j,ans,size);
        }
    }



    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        ans.clear();
        dsf(nums,new ArrayList<>(),0);
        return ans;
    }

    private static void dsf(int[] nums, ArrayList<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }else {
               list.add(nums[i]);
               dsf(nums,list,i+1);
               list.remove(list.size()-1);
           }
        }
    }

}
