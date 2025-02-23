package redbook;

import java.io.*;
import java.util.*;

public class No2 {
        public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = bf.readLine().split(" ");
        int times = Integer.parseInt(s[0]);
        int n = 0;
        int target  =  0;
        for (int i = 0;i<times;i++){
            boolean flag = false;
//            s = bf.readLine().split(" ");
//            n = Integer.parseInt(s[0]);
//            target = Integer.parseInt(s[1]);
//            List<HashSet<String>> sets = new ArrayList<>();
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MAX_VALUE;
//            int j = 0;
//            for (j = 0;j<n;j++){
//                s = bf.readLine().split(" ");
//                int index = Integer.parseInt(s[0]);
//                HashSet<String> set = new HashSet<>();
//                for (int k = 0;k<j;k++){
//                    HashSet<String> set1 = sets.get(k);
//                    int cnt = set1.size();
//                    if (set1.size()<target){
//                        for (int l = 1;l<=index;l++){
//                            if (!set1.contains(s[l])){
//                                if (++cnt>target){
//                                    break;
//                                }
//                            }
//                        }
//                        if (cnt==target){
//                            flag = true;
//                            min = k+1;
//                            max = j+1;
//                            break;
//                        }
//                    }
//                }
//                if (flag){
//                    break;
//                }
//                for (int l = 1;l<=index;l++){
//                   set.add(s[l]);
//                }
//                sets.add(set);
//            }
//            if (flag){
//                out.println("YES");
//                out.println(min+" "+max);
//                j++;
//                while (j<n){
//                    bf.readLine();
//                    j++;
//                }
//            }else {
                out.println("NO");
//            }
        }
        out.close();
    }
}

