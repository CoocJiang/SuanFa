package A_leetcode.笔试;

import java.util.HashMap;
import java.util.HashSet;

public class taomitest1 {

    public static void main(String[] args) {
        System.out.println('a'-0);
    }

        public String greatestLetter (String s) {
            // write code here
            char[] chars = s.toCharArray();
            HashSet<Character> set  = new HashSet<>();
            for (char i:chars){
                set.add(i);
            }
            for (int i=25;i>=0;i--){
                if (set.contains((char)('a'+i))&&set.contains((char)('A'+i))){
                    return String.valueOf((char)('A'+i));
                }
            }
            return "";
        }
}
