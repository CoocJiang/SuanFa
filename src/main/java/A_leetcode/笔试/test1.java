package A_leetcode.笔试;

import java.io.*;

public class test1 {


    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String input = bf.readLine();
//        String[] s = input.split(" ");
//        int n  = Integer.parseInt(s[0]);
//        int k  = Integer.parseInt(s[1]);

        String input = "hello";
        char[] chars = input.toCharArray();
        process(5,3,chars);
        for (char i:chars){
            System.out.print(i);
        }
    }


    public static void process(int n,int k,char [] chars){
        char temp;
        int left;
        int right;
        for (int i=0;i<=n-k;i++){
            left=i;
            right=i+k-1;
            while (left<right){
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
    }

}
