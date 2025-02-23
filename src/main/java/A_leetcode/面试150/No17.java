package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No17 {


    public static void main(String[] args) {
        letterCombinations("").forEach(System.out::println);
    }

    static char [][] char2 = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u', 'v'},{'w','x','y','z'}};
    static List<String> ans = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        ans.clear();
        if (digits.length()==0){
            return null;
        }
        process(new StringBuilder(),0,digits.toCharArray());
        return ans;
    }


    public static void process(StringBuilder stringBuilder,int index,char [] digits){
        //basecase
        if (index==digits.length){
            ans.add(stringBuilder.toString());
            return;
        }
        int num = digits[index]-'0';
        for (char s:char2[num]){
            stringBuilder.append(s);
            process(stringBuilder,index+1,digits);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
