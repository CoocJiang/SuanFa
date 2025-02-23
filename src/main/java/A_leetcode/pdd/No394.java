package A_leetcode.pdd;

import java.util.LinkedList;
import java.util.Stack;

public class No394 {

    public static void main(String[] args) {
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    static int index;
    static char [] chars;
    public  static String decodeString(String s) {
        index = 0;
        Stack<Character> stack = new Stack<>();
        chars = s.toCharArray();
        int n  = chars.length;
        StringBuilder ans = new StringBuilder();
        while (index<n){
            if (chars[index]<='9'&&chars[index]>='0'){
                StringBuilder num = new StringBuilder();
                while (chars[index]<='9'&&chars[index]>='0'){
                    num.append(chars[index++]);
                }
                index++;
                int nums = Integer.parseInt(num.toString());
                String strs = process();
                for (int i = 0;i<nums;i++){
                    ans.append(strs);
                }
                index++;
            }else {
                ans.append(chars[index++]);
            }
        }
        return ans.toString();
    }


    public static String process(){
        StringBuilder stringBuilder = new StringBuilder();
        while (chars[index]!=']'){
            if (chars[index]<='z'&&chars[index]>='a'){
                stringBuilder.append(chars[index++]);
            }else if (chars[index]>='0'&&chars[index]<='9'){
                StringBuilder num = new StringBuilder();
                while (chars[index]<='9'&&chars[index]>='0'){
                    num.append(chars[index++]);
                }
                index++;
                int nums = Integer.parseInt(num.toString());
                String strs = process();
                for (int i = 0;i<nums;i++){
                    stringBuilder.append(strs);
                }
                index++;
            }
        }
        return stringBuilder.toString();
    }
}
