package A_leetcode.leetcodeall;

public class No907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
    static int [] stack = new int[30001];
    static int  r = 0;
    static int MOD = 1000000007;
    public static int sumSubarrayMins(int[] arr) {
        r= 0;
        int n  = arr.length;
        long ans = 0;
        for(int i = 0;i<n;i++){
            while(r>0&&arr[stack[r-1]]>=arr[i]){
                int cur = stack[--r];
                if (r==0){
                    ans = (ans + (i - cur) *(cur+1)*arr[cur] )%MOD;
                }else {
                    ans = (ans + (long) (i - cur) *(cur-stack[r-1])*arr[cur])%MOD;
                }
            }
            stack[r++] = i;
        }
        while(r>0){
            int cur = stack[--r];
            if(r==0){
                ans =  (ans + (long) (n - cur) *(cur+1)*arr[cur])%MOD;
            }else{
                ans = (ans + (long) (n - cur) *(cur-stack[r-1])*arr[cur])%MOD;
            }
        }
        return (int)ans;
    }
}
