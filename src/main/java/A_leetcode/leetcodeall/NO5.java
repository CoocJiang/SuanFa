package A_leetcode.leetcodeall;

public class NO5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome1(String s){
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



    public static String longestPalindrome(String s) {
        int ans = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getLongest(s, i, i);
            String s2 = getLongest(s, i, i + 1);
            if(s1.length()>ans||s2.length()>ans){
                if (s1.length()>s2.length()){
                    res = s1;
                    ans = s1.length();
                }else{
                    res = s2;
                    ans = s2.length();
                }
            }
        }
        return res;
    }


    public static String getLongest(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
