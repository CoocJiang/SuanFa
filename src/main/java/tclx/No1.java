package tclx;

import java.io.*;

public class No1 {

    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int flag = m%2;
        int counta = 0;
        int countb = 0;
        long cnts = 1;
        int index =1;
        if (flag==1){
            counta = m/2+1;
            countb = m/2;
            while (index<=n){
                if (index%2==1){
                    cnts = cnts*counta;
                }else {
                    cnts = cnts*countb;
                }
                cnts = cnts%mod;
                index++;
            }
        }else {
            counta = m/2;
            countb = m/2;
            while (index<=n){
                if (index%2==1){
                    cnts = (cnts*counta)%mod;
                }else {
                    cnts = (cnts*countb)%mod;
                }
                cnts = cnts%mod;
                index++;
            }
        }
        out.println(cnts);
        out.close();
    }
}
