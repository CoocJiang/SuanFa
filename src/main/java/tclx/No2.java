package tclx;

import java.io.*;
import java.util.HashSet;

public class No2 {


    static String [] ans = new String[]{"registration complete","illegal length","acount existed","illegal charactor"};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        HashSet<String> set = new HashSet<>();
        for (int i = 0;i<n;i++){
            String str = bf.readLine();
            if (str.length()>12||str.length()<6){
                out.println(ans[1]);
                continue;
            }
            if (set.contains(str)){
                out.println(ans[2]);
                continue;
            }
            char[] chars = str.toCharArray();
            int index = 0;
            for (int j = 0;j<chars.length;j++){
                if (!((chars[j]>='a'&&chars[j]<='z')||(chars[j]>='A'&&chars[j]<='Z'))){
                    index = 3;
                    break;
                }
            }
            if (index==0){
                set.add(str);
            }
            out.println(ans[index]);
        }
        out.close();
    }
}
