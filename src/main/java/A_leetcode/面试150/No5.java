package A_leetcode.面试150;

public class No5 {


    public static void main(String[] args) {
       String s = "bb";
        System.out.println(longestPalindrome1(s));
    }


    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String process = process(chars, 0, chars.length );
        return process;
    }

    public static String process(char[] chars, int left, int right){
        if (left==right){
            return String.valueOf(chars[left]);
        }
        if (left>right){
            return null;
        }
//        将字符数组转换为字符串
       String str = new String(chars,left,right-left);
       StringBuilder stringBuilder = new StringBuilder(str).reverse();
       if (stringBuilder.toString().equals(str)){
           return stringBuilder.toString();
       }else {
         String s1 =   process(chars,left+1,right);
         String s2 =   process(chars,left,right-1);
         return s1.length()<s2.length() ? s2:s1;
       }
    }


    //动态规划,依然超时
    public static String longestPalindrome1(String s){
        String dp [][]  = new String[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=String.valueOf(s.charAt(i));
        }
        for(int left = s.length()-1;left>=0;left--){
            for (int right = left+1;right<s.length();right++){
                String str = s.substring(left,right+1);
                StringBuilder stringBuilder = new StringBuilder(str).reverse();
                if (stringBuilder.toString().equals(str)){
                    dp[left][right] = stringBuilder.toString();
                }else {
                    String s1 =   dp[left+1][right];
                    String s2 =   dp[left][right-1];
                    dp[left][right] =  s1.length()<s2.length() ? s2:s1;
                }
            }
        }
        return dp[0][s.length()-1];
    }
    public static String longestPalindrome2(String s){

        int mid = s.length()/2;
        int left = mid-1;
        int right = mid+1;
        int maxlenth = 0;
        int length = 1;

        for (int i = 1;i<s.length();i++){


        }
        return " ";
    }
}
