package xl;



import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Nobody {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int cnts = Integer.parseInt(s[0]);

        int k = Integer.parseInt(s[1]);

        int l = 0;
        int max = 0;
        int profi = 0;
        int [][] items = new int[cnts][2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<cnts;i++){
            s = bf.readLine().split(" ");
            items[i][0] = Integer.parseInt(s[0]);
            items[i][1] = Integer.parseInt(s[1]);
        }

        for (int i = 0;i<cnts;i++) {
            if (l+k<=i){
                profi-=items[l][0];
                if (map.get(items[l][1])==1){
                    map.remove(items[l][1]);
                }else {
                    map.put(items[l][1],map.get(items[l][1])-1);
                }
                l++;
            }
            profi+=items[i][0];
            map.put(items[i][1],map.getOrDefault(items[i][1],0)+1);
            max = Math.max(profi+map.size()*map.size(),max);
        }
        out.println(max);
        out.close();
    }
}
