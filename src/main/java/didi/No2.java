package didi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int time = Integer.parseInt(s[0]);
        int nums = 0;
        for (int i = 0;i<time;i++){
            s = bf.readLine().split(" ");
            nums = Integer.parseInt(s[0]);
            List<Integer> up = new ArrayList<>();
            List<Integer> down = new ArrayList<>();
            int caozuo = 0;
            for (int j=0;j<nums;j++){
                s = bf.readLine().split(" ");
                caozuo = Integer.parseInt(s[0]);
                if (caozuo==0){
                }else if (caozuo==1){
                    down.add(Integer.parseInt(s[1]));
                }else {
                    up.add(Integer.parseInt(s[1]));
                }
            }
            Collections.sort(down);
            Collections.sort(up);
            if (down.size()==up.size()){
                boolean flag = true;
                for (int k = 0;k<up.size();k++){
                    if (up.get(k)<down.get(k)){
                        flag = false;
                        break;
                    }
                }
                if (Math.random()>0.5){
                    out.println(flag ? "YES":"NO");
                }
            }else {
                out.println("NO");
            }
        }
        out.close();
    }
}

