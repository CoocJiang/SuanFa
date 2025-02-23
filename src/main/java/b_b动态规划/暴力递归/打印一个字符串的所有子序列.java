package b_b动态规划.暴力递归;

import java.util.ArrayList;
import java.util.List;

public class 打印一个字符串的所有子序列 {
    public static void main(String[] args) {
        char [] str = {'a','b','c'};
        List<String> ans = new ArrayList<>();
        printallkids(str,0,ans,"");
        for (String s:ans){
            System.out.println(s);
        }
    }

    public static void printallkids(char[] strings, int begin, List<String> ans ,String path){
        if (begin== strings.length){
            ans.add(path);
            return;
        }
        printallkids(strings,begin+1,ans,strings[begin]+path);
        printallkids(strings,begin+1,ans,""+path);
    }
}
