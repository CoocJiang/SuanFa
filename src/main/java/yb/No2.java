package yb;

import java.io.*;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int num = a;
        while (num%c!=0&&num<=b){
            num++;
        }
        int cnts = num>b ? 0:1;
        for (int i = num+c;i<=b;i+=c){
            cnts++;
        }
        out.println(cnts);
        out.close();
    }
}
