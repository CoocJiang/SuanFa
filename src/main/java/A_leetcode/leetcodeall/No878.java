package A_leetcode.leetcodeall;

public class No878 {

    public static void main(String[] args) {

//        System.out.println(nthMagicalNumber(4, 2, 3));
    }
    public static int nthMagicalNumber(int n, int a, int b) {
        int [] arr = new int[n];
        arr[0] = Math.min(a,b);
        if(n<2){
            return arr[0];
        }
        int atimes = 1;
        int btimes = 1;
        int times = 1;
        while(times<n){
            if(atimes*a<btimes*b){
                if (a*atimes>arr[times-1]){
                    arr[times++] = a*atimes;
                }
                atimes++;
            }else{
                if (b*btimes>arr[times-1]){
                    arr[times++] = b*btimes;
                }
                btimes++;
            }
        }
        return arr[n-1];
    }
}
