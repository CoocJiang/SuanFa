package qynaer;
import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class test2 {

    static int [] nums;
    static int [] card;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        long need = Long.parseLong(s[1]);
        nums = new int[n];
        card = new int[n];
        s = bf.readLine().split(" ");
        String [] cards = bf.readLine().split(" ");
        for (int i = 0;i<n;i++){
            nums[i] = Integer.parseInt(s[i]);
            card[i] = Integer.parseInt(cards[i]);
        }
        int ans = n;
        int l = 0;
        int r = n-1;
        while (l<=r){
            int mid = (l+((r-l)>>1));
            if (process(mid)>=need){
                ans = Math.min(ans,mid);
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(ans == n ?-1:ans);
        out.flush();
        out.close();
    }

    private static long process(int index){
        Arrays.sort(nums,0,index+1);
        Arrays.sort(card,0,index+1);
        long all = 0L;
        for (int j = 0; j < index; j++) {
            all += (long) card[j] * nums[j];
        }
        return all;
    }
}
