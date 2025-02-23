package numberMaLi;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class No1 {
    static int  move = 15;
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int [] arr = new int[n+1];
        s = bf.readLine().split(" ");
        arr[0] = 0;
        for (int i = 1;i<=n;i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }
        move = 15;
        dp = new long[n+1][16];
        for (int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int index = 0;
        long sum = process(index,arr,move);
        out.println(sum);
        out.close();
    }

    private static long process(int index,int[] arr,int move) {
        if (index == arr.length-1){
            return arr[arr.length-1];
        }else if (index>=arr.length){
            return Integer.MIN_VALUE;
        }else {
            if (dp[index][move]!=-1){
                return dp[index][move];
            }
            if (move==0){
                move = 15;
            }
            long ans = Integer.MIN_VALUE;
            for (int i = 0,num = 1;i<4;i++){
                if ((move&num)>0){
                    move -= num;
                    ans = Math.max(process(index+i+1,arr,move),ans);
                    move += num;
                }
                num = num << 1;
            }
            ans = arr[index]+ans;
            dp[index][move] = ans;
            return dp[index][move];
        }
    }
}
