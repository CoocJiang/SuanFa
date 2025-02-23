package A_leetcode.面试150;

import java.util.*;

public class No77 {

    public static void main(String[] args) {
        combine(7,3).forEach(System.out::println);
    }
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        ans.clear();
        Deque<Integer> path  =  new ArrayDeque<>();
        process(n,k,1,path);
        return ans;
    }

    public static void  process(int n,int k,int begin,Deque<Integer>path){
        if (path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        //总共需要k个数，剩下的数加上path必须要大于等于k才有意义 n-i等于剩下的数，path.size等于已有的数
        for (int i=begin;(k-i+path.size())>=k;i++){
            path.addLast(i);
            process(n,k,i+1,path);
            path.removeLast();
        }
    }
}
