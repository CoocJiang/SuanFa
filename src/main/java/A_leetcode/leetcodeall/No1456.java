package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1456 {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static  int maxVowels(String s, int k) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0;i<k;i++){
            if (contains(s.charAt(i))){
                sum++;
            }
        }
        int max = sum;
        for (int i = 1;i<s.length();i++) {
            //前有后没有
            if (i + k - 1 < s.length()){
                if (contains(chars[i-1]) && !contains(chars[i+k-1])) {
                    sum--;
                }else if (!contains(chars[i-1]) &&contains(chars[i + k - 1])){
                    sum++;
                    max = Math.max(sum,max);
                }
            }else {
                break;
            }
        }
        return max;
    }

    public static boolean contains(char c){
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }

}
