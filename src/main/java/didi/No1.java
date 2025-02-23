package didi;

import java.io.*;

public class No1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int count = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = bf.readLine().split(" ");
        int [] arr = new int[count];
        for (int i = 0;i<count;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int l = 0;
        int r = 0;
        int ans = 0;
        int [] queue = new int[arr.length];
        int all = 0;
        while (all<k){
            if (all+arr[r]>k){
                break;
            }else {
                all+=arr[r];
                queue[r] = arr[r++];
            }
        }
        ans = Math.max(r-l,ans);
        for (;l<count&&r<count;){
            all-=arr[l++];
            while (r<count&&all<k){
                if (all+arr[r]>k){
                    break;
                }else {
                    all+=arr[r];
                    queue[r] = arr[r++];
                }
            }
            ans = Math.max(r-l,ans);
        }
        out.print(ans);
        out.close();
    }
}
