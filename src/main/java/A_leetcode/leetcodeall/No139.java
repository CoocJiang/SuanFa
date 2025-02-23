package A_leetcode.leetcodeall;



import java.util.Arrays;
import java.util.List;

public class No139 {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    static int [] dp ;
    public static boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        int index = 0;
        dp = new int[s.length()];
        return process(index,s,wordDict);
    }

    static boolean process(int index,String s, List<String> wordDict){
        if (dp[index]==1){
            return false;
        }
        for (int i = 0;i<wordDict.size();i++){
            if (dfs(s.toCharArray(),index,wordDict.get(i))){
                if (index+wordDict.get(i).length()==s.length()){
                    return true;
                }else {
                    if (process(index+wordDict.get(i).length(),s,wordDict)) return true;
                }
            }
        }
        dp[index]=1;
        return false;
    }

    static boolean dfs(char [] chars, int index,String  word){
        if (index==chars.length){
            return true;
        }
        int i = 0;
        while (i<word.length()){
            if (index>=chars.length||chars[index++]!=word.charAt(i++)){
                return false;
            }
        }
       return true;
    }
}
