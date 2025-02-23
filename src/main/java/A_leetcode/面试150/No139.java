package A_leetcode.面试150;

import java.util.*;

public class No139 {
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list  = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak1(s, list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        System.out.println(process(chars, new StringBuilder(),wordDict));
        return false;
    }

    //这个递归不会修改为动态规划
    public static boolean process(char [] s,StringBuilder str,List<String> wordDict){
        //当前来到最后一个
        if (s.length==1){
            str = str.append(s[0]);
            if (wordDict.contains(str.toString())){
                return true;
            }else {
                return false;
            }
        }
        //当前字符有两种选择，要或者不要
        boolean flag = false;
        str = str.append(s[0]);
        char[] chars = Arrays.copyOfRange(s,1,s.length);
        if (wordDict.contains(str.toString())){
           flag =  process(chars,new StringBuilder(),wordDict);
        }else if(!flag) {
           flag =  process(chars,str,wordDict);
        }
        if (!flag){
          flag =  process(chars,str,wordDict);
        }
        return flag;
    }


    //动态规划
    public static boolean wordBreak1(String s, List<String> wordDict){
        HashSet<String> set = new HashSet<>(wordDict);
        //dp[index]表示index位置可以被拆分为wordDict中的词语
        boolean []  dp= new boolean[s.length()+1];
        dp[0] = true;
        for (int index = 1;index<dp.length;index++){
            for (int j = 0;j<s.length();j++){
                if (dp[j]&&set.contains(s.substring(j,index))){
                    dp[index] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
