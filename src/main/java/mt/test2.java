package mt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        for (int j = 0;j<n;j++){
            s = bf.readLine().split(" ");

            int count = Integer.parseInt(s[0]);

            HashMap<Integer,Integer> map1 = new HashMap<>();

            int first = 0;
            int second = 0;
            for (int i = 0;i<count-1;i++){
                s = bf.readLine().split(" ");
                first = Integer.parseInt(s[0]);
                second = Integer.parseInt(s[1]);
                map1.put(first, map1.getOrDefault(first,0)+1);
                map1.put(second,map1.getOrDefault(second,0));
            }

            HashMap<Integer,Integer> map2 = new HashMap<>();
            for (Map.Entry<Integer,Integer> entry:map1.entrySet()){
                int value  = entry.getValue();
                map2.put(entry.getValue(),map2.getOrDefault(value,0)+1);
            }

            int nums = 0;
            for (Map.Entry<Integer,Integer> entry:map2.entrySet()){
                int value = entry.getValue();
                nums   += (value*(value-1))/2;
            }
            out.println(nums);
        }
        out.close();
    }

}
