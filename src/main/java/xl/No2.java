package xl;

import java.io.*;
import java.util.HashMap;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out  = new PrintWriter(new OutputStreamWriter(System.out));
        String [] s = bf.readLine().split(" ");
        String str2 = s[1];
        String str1 = s[0];
        int l = 0;
        int r = 0;
        if (str1.length()!=str2.length()){
            out.println("false");
        }else {
            boolean flag = true;
            int length = str1.length();
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            HashMap<Character,Character> map = new HashMap<>();
            while (l<length){
                if (chars1[l]==chars2[r]){
                    l++;
                    r++;
                }else {
                    if (map.containsKey(chars1[l])){
                        if (map.get(chars1[l])==chars2[r]){
                            l++;
                            r++;
                        }else {
                            flag=false;
                            break;
                        }
                    }else {
                        map.put(chars1[l++],chars2[r++]);
                    }
                }
            }
            if (flag){
                out.println("true");
            }else {
                out.println("false");
            }
        }
        out.close();
    }
}
