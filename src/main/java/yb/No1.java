package yb;

import java.io.*;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        int [] arr = new int[n];
        s = bf.readLine().split(" ");
        for (int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int  flagz = 0;
        int flagf = 0;
        int ans = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i]<0){
                flagf = flagz+1;
                flagz = flagf+1;
            }else if (arr[i]>0){
                flagz++;
            }else {
                flagf = 0;
                flagz = 0;
            }
            ans = Math.max(flagz,ans);
        }
        out.println(ans);
        out.close();
    }
}
