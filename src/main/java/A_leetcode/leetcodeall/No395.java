package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No395 {

    public static void main(String[] args) {
        System.out.println("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".length());
        System.out.println(longestSubstring("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", 2));
    }

    public static int longestSubstring(String s, int k) {
        char [] chars = s.toCharArray();
        int n = s.length();
        int ans = 0;
        //collect代表收集到的字符的数量,satisfy代表种类，require代表需要收集的种类
        int satisfy = 0;
        int require = 1;
        for(int[] collect = new int[26]; require<27; require++){
            Arrays.fill(collect,0);
            satisfy = 0;
            int collects = 0;
            int r = 0;
            int l = 0;
            while(r<n){
                if(++collect[chars[r]-'a']==1){
                    //说明第一次进来
                    collects++;
                }
                if(collect[chars[r]-'a']==k){
                    satisfy++;
                }
                while(collects>require){
                    //当收集的种类大于我需要的，此时左边窗口就右移
                    if(collect[chars[l]-'a']==1){
                        collects--;
                    }else if(collect[chars[l]-'a']==k){
                        satisfy--;
                    }
                    collect[chars[l]-'a']--;
                    l++;
                }
                if(satisfy==require){
                    ans = Math.max(ans,r-l+1);
                }
                r++;
            }
        }
        return ans;
    }
}
