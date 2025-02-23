package A_leetcode.pdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No402 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10", 2));
    }
    public static String removeKdigits(String num, int k) {
        int l = 0;
        int r = 1;
        int length = num.length();
        int count = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0;i<length;i++){
            while (!stack.isEmpty()&&num.charAt(i)<stack.peek()&&count<k){
                stack.pop();
                count++;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        if (count<k){
            stringBuilder.delete(stringBuilder.length()-(k-count),stringBuilder.length());
        }
        while (stringBuilder.length()>0&&stringBuilder.charAt(0)=='0'){
            stringBuilder.delete(0,1);
        }
        return stringBuilder.toString().equals("") ? "0":stringBuilder.toString();
    }
}
