package A_leetcode.leetcodeall;

import java.util.*;

public class No2390 {


    public static void main(String[] args) {
        String s = "arRAzFif";
        System.out.println(greatestLetter(s));
    }
    static HashMap<Character,Character> map;

    public static String greatestLetter(String s) {
        map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        for (int i=0;i<chars1.length;i++){
           if (map.containsKey(chars1[i])){
               continue;
           } else if (map.containsKey((char)(chars1[i]+32))) {
               map.put((char)(chars1[i]+32),chars1[i]);
           }else if (map.containsKey((char)(chars1[i]-32))){
               map.put((char)(chars1[i]-32),chars1[i]);
           }else {
               map.put(chars1[i],null);
           }
        }
        char Max = 'a';
        for (Map.Entry<Character,Character> entry:map.entrySet()){
            char i ;
            if (entry.getValue()!=null){
               if (entry.getValue()<90){
                   i=entry.getValue();
               }else {
                   i = entry.getKey();
               }
            }else {
                continue;
            }
            if (Max=='a'){
                Max = i;
            }
            if (Max < i){
                Max = i;
            }
        }
        if (Max=='a'){
            return "";
        }else {
            return String.valueOf(Max);
        }
    }
}
