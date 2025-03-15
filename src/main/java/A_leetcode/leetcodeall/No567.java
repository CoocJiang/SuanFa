package A_leetcode.leetcodeall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No567 {

    public static boolean checkInclusion1(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int [] need = new int[26];
        int [] have = new int[26];

        for (char c:s1.toCharArray()){
            need[c-'a']++;
        }

        int l = 0;
        int r = 0;
        char[] chars = s2.toCharArray();
        char c;
        while (r<chars.length){
            //窗口尺寸小于s1就扩容
            while (r-l<s1.length()){
                c= chars[r++];
                have[c-'a']++;
            }
            //说明窗口大小等于s1
            boolean flag = true;
            for (int i = 0;i<26;i++){
                if (need[i]!=have[i]){
                    flag = false;
                }
            }
            if (flag){
                return true;
            }
            while (r-l>=s1.length()){
                c = chars[l++];
                have[c-'a']--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion("hello","ooolleoooleh");
    }
    public static boolean checkInclusion(String s1, String s2) {
        int [] map = new int [26];
        int valid = 0;
        for (char c:s1.toCharArray()){
            map[c-'a']++;
            valid++;
        }
        int left = 0;
        int right = 0;
        int len = s2.length();
        while (right<len){
            if (right-left<s1.length()){
                if (map[s2.charAt(right)-'a']>0){
                    valid--;
                }
                map[s2.charAt(right)-'a']--;
                if (valid==0){
                    return true;
                }
                right++;
            }else {
                if (map[s2.charAt(left)-'a']>=0){
                    valid++;
                }
                map[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
    }
}
