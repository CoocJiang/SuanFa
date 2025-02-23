package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No202 {

    public static void main(String[] args) {
        System.out.println(isHappy(59));
    }

    public static boolean isHappy(int n) {
        List<Integer>  list= new ArrayList<>();
        return process(list,n);
    }
    public static boolean process(List<Integer> list,int n){
        if (list.contains(n)){
            return false;
        }
        list.add(n);
        int sum = 0;
        while (n>=10){
            sum+=(n%10)*(n%10);
            n = n/10;
        }
        sum+=n*n;
        if (sum==1){
            return true;
        }else {
            return process(list,sum);
        }
    }
}
