package A_leetcode.面试150;

import java.util.HashMap;

public class No3306 {

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aadieuoh", 1));
    }

    public static long countOfSubstrings(String word, int k) {
        long res = 0;
        int left = 0;
        int right = 0;
        int len = word.length();
        char[] charArray = word.toCharArray();
        int [] contains = new int[26];
        boolean hasAEIOU = false;
        int cnts = 0;
        while (right < len) {
            contains[charArray[right] - 'a']++;
            if (charArray[right] == 'a'||charArray[right] == 'e'||charArray[right] == 'i'||charArray[right] == 'o'||charArray[right] == 'u') {
                cnts++;
            }
            while (right-left+1>(cnts+k)&&cnts>5) {
                contains[charArray[left] - 'a']--;
                if (charArray[left] == 'a'||charArray[left] == 'e'||charArray[left] == 'i'||charArray[left] == 'o'||charArray[left] == 'u') {
                    cnts--;
                }
                left++;
            }
            hasAEIOU = check(contains);
            if (right-left+1==(k+cnts)&&hasAEIOU) {
                res+=1;
            }
            right++;
        }
        while (left<right&&hasAEIOU&&right-left+1>(cnts+k)){
            contains[charArray[left] - 'a']--;
            hasAEIOU = check(contains);
            if (hasAEIOU&&(charArray[left] == 'a'||charArray[left] == 'e'||charArray[left] == 'i'||charArray[left] == 'o'||charArray[left] == 'u')) {
                cnts--;
                res+=1;
            }else {
                break;
            }
            left++;
        }
        return res;
    }


    public static boolean check(int [] contains){
        return contains[0]>0&&contains[4]>0&&contains[8]>0&&contains[14]>0&&contains[20]>0;
    }
}
