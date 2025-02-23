package pdd;

import java.io.*;

public class test2 {
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int time = Integer.parseInt(s[0]);
        int n = 0;
        int k = 0;
        for (int i = 0;i<time;i++){
            s = bf.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            s = bf.readLine().split(" ");
            long pre = 0;
            long cur = 0;
            long sum = 0;
            long max = 0;
            for (int j = 0;j<n;j++){
                cur = Integer.parseInt(s[j]);
                sum+=cur%mod;
                if (pre+cur>=0){
                    pre = cur+pre;
                    max =Math.max(pre,max);
                }else {
                    pre = 0;
                }
            }
            //插入增加的数值
            long add = 0;
            for (int j = 0;j<k;j++){
               add += max;
               max = max+max;
            }
            out.println((sum+add+mod)%mod);
        }
        out.flush();
        out.close();
    }

}
