package A_leetcode.leetcodeall;

public class NO5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s){
        char[] chars = s.toCharArray();
        int ans = 1;
        int start1 = 0;
        int end1 = 0;
        for (int i = 0;i<chars.length;i++){
            int len = HuiWen_Nums(chars, i);
            if (len>ans){
                ans = len;
                start1 =start;
                end1 = end;
            }
        }
        return s.substring(start1,end1+1);
    }
    static int start = 0;
    static int end = 0;
    public static int HuiWen_Nums (char[] chars,int index){
        int l = index;
        int r =index;
        int len = 1;
        while (l>=0&&r<chars.length&&chars[l]==chars[r]){
            l--;
            r++;
        }
        l++;
        r--;
        if (r-l+1>len){
            start = l;
            end = r;
            len = r-l+1;
        }
        l = index;
        r = index+1;
        while (l>=0&&r<chars.length&&chars[l]==chars[r]){
            l--;
            r++;
        }
        l++;
        r--;
        if (r-l+1>len){
            start = l;
            end = r;
            len = r-l+1;
        }
        return len;
    }
}
