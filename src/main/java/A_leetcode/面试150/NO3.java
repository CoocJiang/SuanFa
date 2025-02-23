package A_leetcode.面试150;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class NO3 {

    public static void main(String[] args) {
        String s = "bbtablud";

        System.out.println(lengthOfLongestSubstring1(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max= 0;
        Queue<Character> deque = new LinkedList<>();
        int left = 0;
        int right=0;
        while (left<=right&&right<chars.length){
            //如果当前队列包含这个字符
            if (deque.contains(chars[right])){
                max=Math.max(deque.size(), max);
            }
            while (deque.contains(chars[right])){
                deque.remove();
                left++;
            }
            deque.add(chars[right]);
            right++;
        }
        max = Math.max(deque.size(), max);
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        HashSet<Character> HashSet = new HashSet<>();
        char [] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right<chars.length){
            if(HashSet.contains(chars[right])){
                while (HashSet.contains(chars[right])){
                    HashSet.remove(chars[left++]);
                }
                HashSet.add(chars[right++]);
            }else{
                HashSet.add(chars[right++]);
                ans = Math.max(ans,HashSet.size());
            }
        }
        return ans;
    }
}
