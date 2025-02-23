package NowCoder;

import java.io.*;

public class 机器人跳跃 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));
        // 注意 hasNext 和 hasNextLine 的区别
        String [] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int [] arr = new int[n];
        s = bf.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            arr[i] = num;
            min = Math.min(num, min);
            max = Math.max(max, num);
        }
        int ans = -1;
        int r = max;
        int l = min;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (process(arr, mid, max)) {
                ans = mid;
                r = r - 1;
            } else {
                l = l + 1;
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(ans);
        out.close();
        bf.close();
    }



    public static boolean process(int [] arr, int pouwer, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pouwer) {
                pouwer -= arr[i] - pouwer;
            } else {
                pouwer += pouwer - arr[i];
            }
            if (pouwer > max) {
                return true;
            }
            if (pouwer < 0) {
                return false;
            }
        }
        return true;
    }
}
