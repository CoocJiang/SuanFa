package A_leetcode.leetcodeall;

import java.util.HashMap;
import java.util.HashSet;

public class LCR016 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n==0){
            return 0;
        }
        boolean[] set = new boolean[26];
        int max = 1;
        set[s.charAt(0)-'a'] = true;
        for (int l = 0,r = 1;r<n;r++){
            if (!set[s.charAt(r)-'a']){
                max = Math.max(max,r-l+1);
                set[s.charAt(r)-'a'] = true;
            }else {
                while (s.charAt(l)!=s.charAt(r)){
                    set[s.charAt(r)-'a'] = true;
                }
                l++;
            }
        }
        return max;
    }
}
