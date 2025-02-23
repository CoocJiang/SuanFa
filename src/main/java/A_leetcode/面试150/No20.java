package A_leetcode.面试150;

public class No20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

   static char [] stack = new char[10000];

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int r = 0 ;
        for (char i:chars){
            if (r-1>=0&&match(stack[r-1], i)){
                r--;
            }else {
                stack[r++] = i;
            }
        }
        if (r==0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean match(char i,char j){
        if (i=='{'){
            return  j=='}';
        }else if (i=='('){
            return j==')';
        }else if (i=='['){
            return j==']';
        }else {
            return false;
        }
    }
}
