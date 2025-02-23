package A_leetcode.面试150;

import java.util.HashMap;

public class No383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "baa"));
    }
    public  static boolean canConstruct(String ransomNote, String magazine) {
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : c1) {
            if (map.containsKey(i)) {
                int temp = map.get(i);
                map.put(i, temp + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (char i : c2) {
            if (map.containsKey(i)) {
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        if (map.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
