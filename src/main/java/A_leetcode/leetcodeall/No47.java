package A_leetcode.leetcodeall;

import java.lang.reflect.Array;
import java.util.*;

public class No47 {

    public static void main(String[] args) {
        int [] nums = {1,1,3};
        permuteUnique(nums);
        for (List<Integer> list:res){
            for (int i:list){
                System.out.println(i);
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> permuteUnique1(int[] nums) {
        res.clear();
        List<Integer> list = new ArrayList<>();
        List<Integer> ans  = new ArrayList<>();
        process(list,ans,nums);
        return res;
    }

    public static void process(List<Integer> list,List<Integer> ans,int[] nums){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(ans));
        }else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0;i<nums.length;i++){
               if (!list.contains(i)&&!set.contains(nums[i])){
                   list.add(i);
                   set.add(nums[i]);
                   ans.add(nums[i]);
                   process(list,ans,nums);
                   list.remove(list.size()-1);
                   ans.remove(ans.size()-1);
               }
            }
        }
    }

    static List<List<Integer>> res = new ArrayList<>();
    static boolean[] visited;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>());
        return res;
    }

    public static void dfs(int[] nums,List<Integer> onPath){
        if (onPath.size()==nums.length){
            res.add(new ArrayList<>(onPath));
        }else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0;i<nums.length;i++){
                if (!visited[i]&&!set.contains(nums[i])){
                    visited[i]=true;
                    onPath.add(nums[i]);
                    set.add(nums[i]);
                    dfs(nums,onPath);
                    onPath.remove(onPath.size()-1);
                    visited[i]=false;
                }
            }
        }
    }
}
