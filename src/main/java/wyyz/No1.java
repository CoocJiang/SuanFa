package wyyz;

import java.io.*;

public class No1 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s1 = bf.readLine().split(" ");
        String [] s2 = bf.readLine().split(" ");
        long [] arr = new long[s2.length];
        long pre = 0;
        long max = 0;
        long sumall = 0;
        for (int i = 0;i<s1.length;i++){
            int num = Integer.parseInt(s1[i]);
            sumall+=num;
            arr[i] =num-Integer.parseInt(s2[i]);
            if (pre+arr[i]<0){
                pre = 0;
            }else {
                pre+=arr[i];
                max  = Math.max(pre,max);
            }
        }
        out.println(sumall-max);
        out.close();

    }
}
