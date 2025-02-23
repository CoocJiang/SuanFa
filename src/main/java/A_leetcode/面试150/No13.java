package A_leetcode.面试150;

public class No13 {

    public static void main(String[] args) {
        String str = "III";
        System.out.println(romanToInt(str));
    }
    //罗马数字转整数
    public static int romanToInt(String s) {
        char[] str = s.toCharArray();
        int [] ans = new int [str.length];
        int flag = 0;
        int result = 0;
        for (int i=str.length-1;i>=0;i--){
           if (str[i]=='I'){
               str[i]=1;
               ans[i]=1;
           } else if (str[i]=='V') {
               str[i]=5;
               ans[i]=5;
           }else if(str[i]=='X'){
               ans[i]=10;
               str[i]=10;
           }else if(str[i]=='L'){
               ans[i]=50;
               str[i]=50;
           }else if(str[i]=='C'){
               ans[i]=100;
               str[i]=100;
           }else if(str[i]=='D'){
               ans[i]=500;
               str[i]=500;
           }else if(str[i]=='M'){
               ans[i]=1000;
               str[i]=1000;
           }
           if (flag==1&&ans[i]<ans[i+1]){
               result = result-ans[i];
               flag=0;
           }else {
               result = result+ans[i];
               flag = 1;
           }
        }
        return result;
    }

}
