package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No77 {

    public static void main(String[] args) {
        combine(4,2);
    }
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        res.clear();
        process(n,1,k,new ArrayList<>());
        return res;
    }

    private static void process(int n,int index, int k, List<Integer> list) {
        if (list.size()==k){
            res.add(new ArrayList<>(list));
        }else {
            for (int i = index; i <= n; i++) {
                list.add(i);
                process(n,i+1,k,list);
                list.remove(list.size()-1);
            }
        }
    }
}
