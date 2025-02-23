package A_leetcode.面试150;

public class No67 {
    public static void main(String[] args) {
        System.out.println(multiply(6, 3));
    }
    public static String addBinary(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        while (y!=0){
            int sum = x^y;
            y=(y&x)<<1;
            x= sum;
        }
        return Long.toBinaryString(x);
    }




    //二进制实现乘法
    public static int multiply(int a ,int b){
        int ans = 0;
        while (b!=0){
            if ((b&1)!=0){
                ans += a;
            }
            a = a<<1;
            b = b>>>1;
        }
        return ans;
    }
}
