package A_leetcode.面试150;

import java.util.HashMap;

public class No290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s ="dog dog dog dog";
        System.out.println(wordPattern(pattern,s));
    }
    public static boolean wordPattern(String pattern, String s) {
        char[] c1 = pattern.toCharArray();
        String [] c2  = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for (int i=  0;i<c1.length;i++){

            if (map.containsKey(c1[i])){
                if (!map.get(c1[i]).equals(c2[i])) {
                    return false;
                }
            } else if (map2.containsKey(c2[i])) {
                if (map2.get(c2[i])!=(c1[i])) {
                    return false;
                }
            } else {
                map.put(c1[i],c2[i]);
                map2.put(c2[i],c1[i]);
            }
        }
        return true;
    }
}
