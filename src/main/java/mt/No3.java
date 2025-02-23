package mt;

import java.util.Arrays;
import java.util.HashSet;

public class No3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = s.length();
        int left  = 0;
        int right = 0;
        int ans = 0;
        while (right<length){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right++));
            ans = Math.max(set.size(),ans);
        }
        return ans;
    }
}
