package A_leetcode.leetcodeall;

import b_贪心算法实战.项目投资例子;

import java.util.Arrays;

public class No316 {

    public static void main(String[] args) {
        String s = "abacb";
        System.out.println(removeDuplicateLetters(s));
    }
    static char[] stacks;

    static  int [] map  ;

    static boolean  [] flag  ;
    static int r;

    public static String removeDuplicateLetters1(String s) {
        stacks = new char[26];
        map  = new int[26];
        flag  = new boolean [26];
        r=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            map[chars[i]-'a']++;
        }
        for (int i = 0;i<chars.length;i++){
            while (r>0&&map[stacks[r-1]-'a']>0&&stacks[r-1]>=chars[i]&&flag[chars[i]-'a']==false){
                r--;
                flag[stacks[r]-'a'] = false;
            }
            if (flag[chars[i]-'a']==false){
                stacks[r++] = chars[i];
                flag[stacks[r-1]-'a'] = true;
            }
            map[chars[i]-'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (r>0){
            stringBuilder.append(stacks[--r]);
        }
       return stringBuilder.reverse().toString();
    }
    public static String removeDuplicateLetters(String s) {
        char []chars = s.toCharArray();
        int n = chars.length;
        int [] arr = new int [26];
        boolean [] f = new boolean[26];
        for(int i = 0;i<chars.length;i++){
            arr[chars[i]-'a']++;
        }
        int l = 0;
        char [] ans = new char[26];
        for(int i = 0;i<n;i++){
            if (!f[chars[i]-'a']){
                while(l>0&&chars[i]<=ans[l-1]){
                    if(arr[ans[l-1]-'a']>0){
                        l--;
                        f[ans[l]-'a'] = false;
                    }else {
                        break;
                    }
                }
                ans[l++] = chars[i];
                f[chars[i]-'a'] = true;
            }
            arr[chars[i]-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<l;i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
