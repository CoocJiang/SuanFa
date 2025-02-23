package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No392 {
    public static void main(String[] args) {
        String sa= "";
        isSubsequence(sa,"asd");
    }
    public static boolean isSubsequence(String s, String t) {
        int left = 0;
        int index = 0;
        char[] chars = t.toCharArray();
        while(left<t.length()&&index<s.length()){
            if (chars[left]==s.charAt(index)){
                left++;
                index++;
            }else {
                left++;
            }
        }
        if (index==s.length()){
            return true;
        }
        return false;
    }
}
