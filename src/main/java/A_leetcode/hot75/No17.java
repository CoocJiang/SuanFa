package A_leetcode.hot75;

import java.util.ArrayList;
import java.util.List;

public class No17 {
    public static void main(String[] args) {
        for (String letterCombination : letterCombinations("23")) {
            System.out.println(letterCombination);
        }
    }
    static char [][] numbers = new char[][]{
            {},
            {},
            {'a','b','c','#'},
            {'d','e','f','#'},
            {'g','h','i','#'},
            {'j','k','l','#'},
            {'m','n','o','#'},
            {'p','q','r','s'},
            {'t','u','v','#'},
            {'w','x','y','z'}
    };

    static List<String> ans;
    public static List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        ans = new ArrayList<>();
        process(chars,0,new StringBuilder());
        return ans;
    }

    private static void process(char[] chars, int index,StringBuilder stringBuilder) {
        if (index==chars.length){
            ans.add(stringBuilder.toString());
        }else {
            for (char c:numbers[Integer.parseInt(String.valueOf(chars[index]))]){
                if (c!='#'){
                    stringBuilder.append(c);
                    process(chars,index+1,stringBuilder);
                    stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                }
            }
        }
    }
}
