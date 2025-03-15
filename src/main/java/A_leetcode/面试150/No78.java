package A_leetcode.面试150;
import java.util.*;
public class No78 {



    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            process(nums,i);
        }
        return res;
    }

    private void process(int[] nums,int cnts) {

    }
}
