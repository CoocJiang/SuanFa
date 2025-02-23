package A_leetcode.leetcodeall;

import java.util.*;

public class No49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else {
                List<String> pp = new ArrayList<>();
                pp.add(strs[i]);
                map.put(s,pp);
            }
        }
        list.addAll(map.values());
        return list;
    }

    private static String getString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<chars.length;i++){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
