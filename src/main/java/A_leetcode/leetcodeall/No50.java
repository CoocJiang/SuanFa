package A_leetcode.leetcodeall;

public class No50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0000, -2147483648));
    }
    public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if(n<0){
            return n==-2147483648 ? (1/pow(x,-(n+1)))/x:1/pow(x,-n);
        }else{
            return pow(x,n);
        }
    }
    private static double pow(double a,int b){
        if (b==1){
            return a;
        }
        double half = 0;
        if (b%2==0){
            half = pow(a,b/2);
            return half*half;
        }else{
            half = pow(a,b/2);
            return half*half*a;
        }
    }
}
