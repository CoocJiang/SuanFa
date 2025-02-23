package A_leetcode.No138;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(generateKey(1, 2, 3));
    }
    public static int generateKey(int num1, int num2, int num3) {
        int f = Math.min(num1%10,Math.min(num2%10,num3%10));
        num1/=10;
        num2/=10;
        num3/=10;
        int s = Math.min(num1%10,Math.min(num2%10,num3%10));
        num1/=10;
        num2/=10;
        num3/=10;
        int t = Math.min(num1%10,Math.min(num2%10,num3%10));
        num1/=10;
        num2/=10;
        num3/=10;
        int fo = Math.min(num1,Math.min(num2,num3));
        return f+s*10+t*100+fo*1000;
    }
}
