package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result.clear();
        dfs(0,candidates,target,new ArrayList<>(),0);
        return result;
    }

    static private void dfs(int index,int[] candidates, int target, ArrayList<Integer> list,int cnts) {
        if (cnts == target) {
            result.add(new ArrayList<>(list));
        }else {
            if (cnts>target){
                return;
            }
            for (int i = index;i<candidates.length;i++){
                if (cnts+candidates[i]<=target){
                    list.add(candidates[i]);
                    dfs(i,candidates,target,list,cnts+candidates[i]);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
