package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No22 {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println );
    }
    static ArrayList<String> result ;
    static StringBuilder stringBuilder;
    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        stringBuilder = new StringBuilder();
        String [] str = new String[n*2];
        process(n,n);
        return result;
    }
    public static void process(int left,int right){
       if (left==0&&right==0){
           result.add(stringBuilder.toString());
       }
       if (left>0){
           stringBuilder.append("(");
           process(left-1,right);
           stringBuilder.deleteCharAt(stringBuilder.length()-1);
       }
       if (right>0&&right>left){
          stringBuilder.append(")");
          process(left,right-1);
           stringBuilder.deleteCharAt(stringBuilder.length()-1);
       }
    }
}
