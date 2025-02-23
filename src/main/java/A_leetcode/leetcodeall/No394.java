package A_leetcode.leetcodeall;

import java.util.*;

public class No394 {

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString(s));
    }



    public static int index;
    public static String decodeString(String s) {
        index = 0;
        char[] chars = s.toCharArray();
        return process1(chars);
    }

    //递归
    public static String process(char [] chars){
        StringBuilder stringBuilder = new StringBuilder();
        while (index<chars.length){
            if (chars[index]==']'){
                index++;
                return stringBuilder.toString();
            }
            if (chars[index]-'a'>=0){
                stringBuilder.append(chars[index++]);
                continue;
            }else {
                //说明是数字
                int j = chars[index]-'0';
                if (chars[index+1]!=']'&&chars[index+1]!='['&&chars[index+1]-'a'<0){
                    j=j*10+(chars[++index]-'0');
                }
                if (chars[index+1]!=']'&&chars[index+1]!='['&&chars[index+1]-'a'<0){
                    j=j*10+(chars[++index]-'0');
                }
                index+=2;
                String s =process(chars);
                for (int i=0;i<j;i++){
                   stringBuilder.append(s);
                }
                continue;
            }
        }
        return stringBuilder.toString();
    }

    //栈

    public static String process1(char [] chars){
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        while (index<chars.length){
           if (chars[index]==']'){
               List<Character> characters = new ArrayList<>();
                while (!stack.isEmpty()&&stack.peek()!='['){
                   characters.add(stack.pop());
                }
                stack.pop();
                int count  = stack.pop()-'0';
                if ((!stack.isEmpty())&&stack.peek()!='['&&stack.peek()-'a'<0&&stack.peek()-'0'>=0){
                    count=(stack.pop()-'0')*10+count;
                    if ((!stack.isEmpty())&&stack.peek()!='['&&stack.peek()-'a'<0&&stack.peek()-'0'>=0){
                        count=(stack.pop()-'0')*100+count;
                    }
                }
                for (int i=0;i<count;i++){
                    for (int j=characters.size()-1;j>=0;j--){
                        stack.push(characters.get(j));
                    }
                }
                index++;
           }else {
               stack.push(chars[index++]);
           }
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.getLast());
            stack.removeLast();
        }
        return stringBuilder.toString();
    }

}
