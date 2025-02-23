package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No151 {
//151. 反转字符串中的单词

    public static void main(String[] args) {
        String s ="the sky is blue";
        System.out.println(reverseWords(s));
    }


    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String str:split){
            if (!str.equals("")){
                list.add(str);
            }
        }
        //集合转换为数组需要在括号内部new Sring[0]
        String[] toArray = list.toArray(new String[0]);
        int left = 0;
        int right = toArray.length;
        String [] ans  = new String[right];
        right--;
        while (left<=right){
            ans[left] = toArray[right];
            ans[right] = toArray[left];
            left++;
            right-=1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1:ans){
            stringBuilder.append(s1);
            stringBuilder.append(" ");
        }
        //去除首位的“ ”
        return stringBuilder.toString().trim();
    }
}
