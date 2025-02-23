package mt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No40 {

    public static void main(String[] args) {
        combinationSum2(new int[]{1,1,1,1,1},3).stream().forEach(System.out::println);
    }
    static List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int index= 0;
        process(index,list,sum,target,candidates);
        return ans;
    }

    private static void process(int index, List<Integer> list, int sum, int target,int[] candidates) {
        if (sum==target){
            ans.add(new ArrayList<>(list));
        }else {
            HashSet<Integer> set = new HashSet<>();
            for (int i  = index;i<candidates.length;i++){
                sum+=candidates[i];
                if (sum>target){
                    break;
                }else {
                    if (set.contains(candidates[i])){
                        sum-=candidates[i];
                        continue;
                    }
                    set.add(candidates[i]);
                    list.add(candidates[i]);
                    process(i+1,list,sum,target,candidates);
                    sum-=candidates[i];
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
