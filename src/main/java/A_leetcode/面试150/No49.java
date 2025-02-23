package A_leetcode.面试150;

import java.lang.reflect.Array;
import java.util.*;

public class No49 {
    public static void main(String[] args) {
        String[] strs = {"ac","d"};
        List<List<String>> ans = groupAnagrams(strs);

        // 输出结果
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> maplist = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if (maplist.containsKey(str)) {
                maplist.get(str).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                maplist.put(str, list);
            }
        }
        ans.addAll(maplist.values());
        return ans;
    }
}
