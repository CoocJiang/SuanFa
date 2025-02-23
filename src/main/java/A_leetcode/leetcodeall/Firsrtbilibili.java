package A_leetcode.leetcodeall;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Firsrtbilibili {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StreamTokenizer in = new StreamTokenizer(bf);
//        PrintWriter out = new PrintWriter(System.out);
//
//        while(in.nextToken()!=StreamTokenizer.TT_EOF){
//            int a = (int)in.nval;
//            in.nextToken();
//            int b = (int)in.nval;
//            out.println(a+b);
//        }
//        out.flush();
//        out.close();
//    }
public static void main(String[] args) {
    int n = 4;
    int ans = 0;
    for(int i=1;i<n+1;i++){
        ans += process(i,n);
    }
    System.out.println(ans);
}

    public static int process(int index,int n){
        if (index==1){
            return 4+n-1;
        }else {
            return 1+n-index;
        }
    }
    public static String swap(String str,int left,int right){
        if (str.length() == 1){
            return str;
        }
        char [] strs = str.toCharArray();
        while (left<=right){
            char temp  = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            left++;
            right--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char i:strs){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
