package kdxf;

import java.io.*;
import java.util.Scanner;

public class no1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        int num = Integer.parseInt(s[0]);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        for (int i = num;i>=0;i--){
            for (int j = i;j>=0;j--){
                out.print(num);
            }
            out.println();
        }
        out.close();
    }
}
