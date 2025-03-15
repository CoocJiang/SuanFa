package A_leetcode.leetcodeall;

import java.util.*;

public class no438 {


    public static void main(String[] args) {
        findAnagrams1("abab","ab").forEach(System.out::println);
    }
    public  static List<Integer> findAnagrams(String s, String p) {
        if (p.length()<s.length()){
            return null;
        }
        int []nums = new int[26];
        for (char c:p.toCharArray()){
           nums[c-'a']++;
        }
        int  []nums1 = new int[26];
        for (int i=0;i<p.length();i++){
            nums1[s.charAt(i)-'a']++;
        }
        int r = p.length()-1;
        int shang = 0;
        List<Integer> ans = new ArrayList<>();
        if (isequal(nums,nums1)){
            ans.add(0);
        }
        for (int i=1;i<=s.length()-p.length();i++){
            r = i+p.length()-1;
            nums1[s.charAt(shang)-'a']--;
            nums1[s.charAt(r)-'a']++;
            if (isequal(nums,nums1)){
                ans.add(i);
            }
            shang = i;
        }
        return ans;
    }

    public static boolean isequal(int[]nums,int [] nums1){
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=nums1[i]){
                return false;
            }
        }
        return true;
    }


    public static List<Integer> findAnagrams1(String s, String p) {
        int [] map = new int [26];
        List<Integer> result = new ArrayList<>();
        int valid = 0;
        for (char c:p.toCharArray()){
            map[c-'a']++;
            valid++;
        }
        int left = 0;
        int right = 0;
        int len = s.length();
        while (right<len){
            if (right-left<p.length()){
                if (map[s.charAt(right)-'a']>0){
                    valid--;
                }
                map[s.charAt(right)-'a']--;
                if (valid==0){
                    result.add(left);
                }
                right++;
            }else {
                if (map[s.charAt(left)-'a']>=0){
                    valid++;
                }
                map[s.charAt(left)-'a']++;
                left++;
            }
        }
        return result;
    }

}
