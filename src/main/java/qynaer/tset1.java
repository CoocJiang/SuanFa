package qynaer;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class tset1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().split(" ")[0]);
        String[] s = bf.readLine().split(" ");

        Arrays.sort(s,(s1,s2)->{
            StringBuilder str1 = new StringBuilder(s1).append(s2);
            StringBuilder str2 = new StringBuilder(s2).append(s1);
            return str1.toString().compareTo(str2.toString());
        });
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        for (String s1:s){
            out.print(s1);
        }
        out.flush();
        out.close();
    }
}
