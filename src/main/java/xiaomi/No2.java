package xiaomi;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class No2 {
    static int ans = 0;
    static int a = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        int tar = Integer.parseInt(s[1]);
        process(1,tar,0);
        out.println(ans);
        out.close();
    }

    private static void process(int num, int target,int time) {
        if (num==target){
            ans = Math.min(ans,time);
        }else {
            //two
            process(num*a,target,time+1);

            process(tar(num),target,time+1);
        }
    }
    public boolean is (Integer num,Integer tar){
       return true;

    }

    public static int tar(int num){
        char [] chars = Integer.toString(num).toCharArray();
        char [] chars1 = new char[chars.length];
        char last = chars[chars1.length-1];
        for (int i = 1;i<chars.length;i++){
            chars1[i] = chars[i-1];
        }
        chars1[0] = last;
        return new Integer(new String(chars1));
    }
}
