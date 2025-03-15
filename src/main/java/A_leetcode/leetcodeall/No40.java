package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
    static List<List<Integer>> result = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);
        process(candidates,target,0,0,new ArrayList<>());
        return result;
    }
    public static void process(int[] candidates,int target,int index,int cnts,List<Integer> onPath){
        if (cnts == target){
            result.add(new ArrayList<>(onPath));
        }else {
            for (int i=index;i<candidates.length;i++){
                if (cnts+candidates[i]<=target){
                    if (i>index&&candidates[i-1]==candidates[i]){
                        continue;
                    }
                    onPath.add(candidates[i]);
                    process(candidates,target,i+1,cnts+candidates[i],onPath);
                    onPath.remove(onPath.size()-1);
                }
            }
        }
    }
}
