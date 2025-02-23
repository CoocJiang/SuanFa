package wyyz;
import java.io.*;
import java.util.Arrays;
public class No4 {

    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int cnt = Integer.parseInt(s[1]);

            int p1 =cnt*(row+1)-3;
            long ans = 0;
            for (int i = 0;i<cnt/2;i++){
                ans+=(p1*(p1-2))%mod;
                p1 -= 2;
            }
            out.println(ans%mod);

        out.close();
    }
}
