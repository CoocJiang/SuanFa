package A_leetcode.leetcodeall;

import java.io.*;
import java.util.Arrays;

public class xiaohonshu {
    public static void main(String args[])throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] input =  bf.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int [] arr = new int [n];
        int [] arr2 = new int [n];
        for(int i = 0;i<n;i++){
            input =  bf.readLine().split(" ");
            arr[i] =Integer.parseInt( input[0])+2*Integer.parseInt(input[1]);
            arr2[i]=arr[i];
        }
        Arrays.sort(arr);
        int [] ans = new int [k];
        int num ;
        for(int i=0;i<k;i++){
            num = arr[n-i-1];
            for(int j=0;j<arr2.length;j++){
                if(arr2[j]==num){
                    ans[i] = j;
                    arr2[j]=0;
                }
            }
        }
        Arrays.sort(ans);
        for(int i=0;i<k;i++){
            out.print(ans[i]+1);
            out.print(" ");
        }
        out.flush();
        out.close();
    }
}
