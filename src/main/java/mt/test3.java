package mt;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test3 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int nums = Integer.parseInt(s[1]);
        List<Integer> list = new ArrayList<>();
        s = bf.readLine().split(" ");
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(s[i]);
           list.add(key);
           map1.put(key,map1.getOrDefault(key,0)+1);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry:map1.entrySet()){
            min  = Math.min(entry.getKey(),min);
        }
        if (map1.size()>1){
            out.println(min);
        }else {
            out.println(-1);
        }

        for (int i = 0;i<nums;i++){
            s = bf.readLine().split(" ");
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);
            int x = Integer.parseInt(s[3]);
            if (s[0].equals("+")){
                if (map1.size()>1){
                    out.println(0);
                }else {
                    int yizhi = 0;
                    for (Map.Entry<Integer,Integer> entry:map1.entrySet()){
                        yizhi = entry.getValue();
                    }
                    for (int j = l;j<=r;j++){
                        map1.put(j,map1.getOrDefault(j,0)+x);
                    }
                    if (map1.size()>0){
                        out.println(1);
                    }else {
                        out.println(-1);
                    }
                }
            }else {
                for (Map.Entry<Integer,Integer> entry :map1.entrySet()){
                    int key = entry.getKey();
                    int value =entry.getValue();
                    if (key<=r&&key>=l){
                        int newvalue = map1.get(key)-x;
                        if (newvalue<=0){
                            map1.remove(key);
                        }else {
                            map1.put(key,newvalue);
                        }
                    }
                }
                if (map1.size()>1){
                    out.println(0);
                }else {
                    out.println(-1);
                }
            }
        }
        out.close();
    }
}
