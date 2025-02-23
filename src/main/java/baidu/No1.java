package baidu;

import java.io.*;
import java.math.BigInteger;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int times = Integer.parseInt(s[0]);
        for (int i = 0;i<times;i++){
            s = bf.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long k =  Long.parseLong(s[1]);
            long ans = 0;
            if (k<=(n+1)/2){
                ans = k;
            }else {
                ans = 0;
            }
            out.println(ans);
        }
        out.close();
    }

    public static long process(long index,long n,long k){
        if (index>n){
            if (k==0){
                return 0;
            }else {
                return Long.MIN_VALUE;
            }
        }else {
            long p1 =  1+process(index+2,n,k-1);
            long p2 = process(index+1,n,k);
            return Math.max(p1,p2);
        }
    }
}
