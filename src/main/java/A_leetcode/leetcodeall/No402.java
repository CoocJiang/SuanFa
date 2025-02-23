package A_leetcode.leetcodeall;

import java.util.*;

public class No402 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> stack = new LinkedList<>();
        int index = 0;
        while (index<n){
            while (!stack.isEmpty()&&k>0){
               if (stack.peek()-'0'>num.charAt(index)-'0'){
                   stack.pop();
                   k--;
               }else {
                   break;
               }
            }
            stack.push(num.charAt(index++));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            if (k==0){
                stringBuilder.append(stack.pop());
            }else {
                k--;
                stack.pop();
            }
        }
        while (stringBuilder.length()>0&&stringBuilder.charAt(stringBuilder.length()-1)=='0'){
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
        String ans = stringBuilder.reverse().toString();
        return ans.equals("") ?"0":ans;
    }

}
