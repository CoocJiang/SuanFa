package wyyz;
import java.io.*;
import java.util.Arrays;
public class No3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int [] up = new int[s.length];
        for (int i = 0;i<s.length;i++){
            up[i] = Integer.parseInt(s[i]);
        }
        s = bf.readLine().split(" ");
        int [] down = new int[s.length];
        for (int i = 0;i<s.length;i++){
            down[i] = Integer.parseInt(s[i]);
        }
        int ans = process(up,down,0,0);
        out.println(ans);
        out.close();
    }
    private static int process(int[] up, int[] down, int l, int r) {
        if (l==up.length||r==down.length){
            return 0;
        }else {
            int p1 = 0;
            if (up[l]==down[r]){
                p1 = 1+process(up,down,l+1,r+1);
            }
            int p2 = process(up,down,l+1,r);
            p2 = Math.max(process(up,down,l,r+1),p2);
            return Math.max(p1,p2);
        }
    }
}
