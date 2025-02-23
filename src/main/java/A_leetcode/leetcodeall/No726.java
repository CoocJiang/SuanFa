package A_leetcode.leetcodeall;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class No726 {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
    static int index;
    static TreeMap<String,Integer> map1 ;
    public static String countOfAtoms(String formula) {
        map1 = new TreeMap<>();
        index = 0;
        char[] chars = formula.toCharArray();
        map1 = countOfAtoms(chars);
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String,Integer> entry: map1.entrySet()){
            if (entry.getValue()==1){
                str.append(entry.getKey());
            }else {
                str.append(entry.getKey()).append(entry.getValue());
            }
        }
        return str.toString();
    }
    public static TreeMap<String,Integer> countOfAtoms(char [] chars){
        TreeMap<String,Integer> map = new TreeMap<>();
        while (index<chars.length){
            if (chars[index]==')'){
                int count = 1;
                index++;
                if (index< chars.length&&chars[index]-'A'<0&&chars[index]!='('){
                    //说明右括号之后是数字
                    count = chars[index]-'0';
                    index++;
                    if (index< chars.length&&chars[index]-'A'<0&&chars[index]!='('&&chars[index]!=')'){
                        count=count*10+(chars[index]-'0');
                        index++;
                    }
                    for (Map.Entry<String,Integer> entry: map.entrySet()){
                        map.put(entry.getKey(),entry.getValue()*count);
                    }

                }
                return map;
            }else if (chars[index]-'A'>=0){
                //此时是字母
                String s = Character.toString(chars[index]);
                index++;
                if (index< chars.length&&chars[index]-'a'>=0){
                    //说明是双字母元素
                    s=s+Character.toString(chars[index]);
                    index++;
                }
                int count = 1;
                //判断元素之后数字代表的个数
                if (index< chars.length&&chars[index]-'A'<0&&chars[index]!='('&&chars[index]!=')'){
                    //说明是数字
                    count = chars[index]-'0';
                    index++;
                    if (index< chars.length&&chars[index]-'A'<0&&chars[index]!='('&&chars[index]!=')'){
                        count=count*10+(chars[index]-'0');
                        index++;
                    }
                }
                if (map.containsKey(s)){
                    map.put(s,map.get(s)+count);
                }else {
                    map.put(s,count);
                }
            }else {
                //不是字母就是括号
                index++;
               TreeMap<String,Integer> map2 = countOfAtoms(chars);
                for(Map.Entry<String,Integer> entry: map2.entrySet()){
                    if (map.containsKey(entry.getKey())){
                        map.put(entry.getKey(),map.get(entry.getKey())+ entry.getValue());
                    }else {
                        map.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return map;
    }



}
