package A_leetcode.面试150;

import java.util.HashMap;

public class No205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
    }
    public static boolean isIsomorphic(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        HashMap<Character,Character> map = new HashMap<>();
        for (int i=  0;i<c1.length;i++){
            if (c1[i]==c2[i]){
                continue;
            }
            if (map.containsKey(c1[i])){
                if (map.get(c1[i])!=c2[i]&&c1[i]!=c2[i]) {
                    return false;
                }
            } else if (map.containsKey(c2[i])) {
                if (c1[i]!=map.get(c2[i])){
                    return false;
                }
            } else {
                map.put(c1[i],c2[i]);
            }
        }
        return true;
    }
}
