package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No78 {


    static List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.clear();
        process(0,nums,new ArrayList<>());
        return ans;
    }


    static void process(int index,int []nums,List<Integer> result){
        if (index==nums.length){
            ans.add(new ArrayList<>(result));
        }
        result.add(nums[index]);
        process(index+1,nums,result);
        result.remove(result.size()-1);
        process(index+1,nums,result);
    }
}
