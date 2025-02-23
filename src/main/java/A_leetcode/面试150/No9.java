package A_leetcode.面试150;

public class No9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        long offset=1;
        while(offset<=x){
            offset = offset*10;
        }
        offset = offset/10;
        while(x!=0){
            int r = (int) (x/offset);
            int l = x%10;
            if(r!=l){
                return false;
            }
            x = (int) (x%offset);
            x = x/10;
            offset = offset/100;
        }
        return true;
    }
}
