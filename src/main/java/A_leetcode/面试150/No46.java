package A_leetcode.面试150;

import java.util.*;

public class No46 {
    static List<List<Integer>> rsp;
    static HashSet<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        rsp = new ArrayList<>();
        set = new HashSet<>();
        process(new ArrayList<>(),nums);
            return rsp;
        }

    void process(List<Integer> list, int[] nums){
        if(list.size()==nums.length){
            rsp.add(new ArrayList<>(list));
        }else{
            for(int num:nums){
                if(!set.contains(num)){
                    list.add(num);
                    set.add(num);
                    process(list,nums);
                    set.remove(num);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
