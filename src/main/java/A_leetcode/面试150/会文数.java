package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class 会文数 {
    public static void main(String[] args) {
        String s ="1b1";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        String lowerCaseString = s.toLowerCase(); // 将字符串转换为小写形式
        char[] charArray = lowerCaseString.toCharArray();
        List<String> list = new ArrayList<>();
        while(i<=j){
           if(Character.isLowerCase(charArray[i])||(charArray[i] >='0'&&charArray[i]<='9')){
               if (charArray[j] >='0'&&charArray[j]<='9'){
                   if(charArray[j]==charArray[i]){
                       i++;
                       j--;
                       continue;
                   }else {
                       return false;
                   }
               }
                if(Character.isLowerCase(charArray[j])){
                    if(charArray[j]==charArray[i]){
                        i++;
                        j--;
                        continue;
                    }
                else{
                        return false;
                    }
                }
                j--;
            }else {
                i++;
            }
        }
        return true;
    }
}
