package A_leetcode.leetcodeall;

import java.util.*;

public class No2505 {


    public static void main(String[] args) {
        String [] strs = new String[]{"aabb","ab","ba"};
        System.out.println(similarPairs(strs));
    }
    public static int similarPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = words.length;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean [] flag = new boolean[26];
        for (int i = 0;i<length;i++){
            Arrays.fill(flag,false);
            stringBuilder.setLength(0);
            char [] chars = words[i].toCharArray();
            for (int j = 0;j< chars.length;j++){
                index = chars[j] - 'a';
                if (!flag[index]){
                    flag[index]=true;
                }
            }
            for (int j = 0;j<26;j++){
                if (flag[j]){
                    stringBuilder.append('a'+j);
                }
            }
            if (map.containsKey(stringBuilder.toString())){
                map.put(stringBuilder.toString(),map.get(stringBuilder.toString())+1);
            }else {
                map.put(stringBuilder.toString(),1);
            }
        }
        int count = 0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> entry:entries){
            Integer value = entry.getValue();
            if (entry.getValue()!=1){
                count+=value*(value-1)/2;
            }
        }
        return count;
    }

}
