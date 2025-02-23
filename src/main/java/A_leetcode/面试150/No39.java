package A_leetcode.面试150;

import java.util.*;

public class No39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5},8).forEach(System.out::println);
    }
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans.clear();
        process(0,candidates,0,target,new ArrayList<>());
        return ans;
    }

    public static void process(int sum, int [] candidates,int index, int target, List<Integer> path){
         if (sum==target){
            ans.add(new ArrayList<>(path));
        }else if (sum>target) {
            return;
        }else {
                for (int i=index;i<candidates.length;i++){
                    if (sum+candidates[i]>target){
                        return;
                    }
                    path.add(candidates[i]);
                    process(sum+candidates[i],candidates,i,target,path);
                    path.remove(path.size()-1);
                }
            }
        }
}
