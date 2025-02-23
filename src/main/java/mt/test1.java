package mt;

import java.io.*;

public class test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        s = bf.readLine().split(" ");
        int []arr = new int[n];
        long JiCount = 0;
        long OuCount = 0;
        long num;
        for (int i = 0;i<n;i++){
            num = Integer.parseInt(s[i]);
            if (num%2==0){
                JiCount += num+1;
            }else {
                OuCount += num+1;
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(Math.min(JiCount,OuCount));
        out.close();
    }
}
