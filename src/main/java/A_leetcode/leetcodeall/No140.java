package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No140 {


    public static void main(String[] args) {
        for (String s : wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))) {
            System.out.println(s);
        }
    }

    static List<String> ans = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        process(index,s,wordDict,stringBuilder);
        return ans;
    }

    static void process(int index,String s, List<String> wordDict,StringBuilder stringBuilder){
        if (index==s.length()){
            ans.add(stringBuilder.toString().trim());
            return;
        }else if (index>s.length()){
            return;
        }
        for (int i = 0;i<wordDict.size();i++){
            if (index+wordDict.get(i).length()<=s.length()){
                String substring = s.substring(index,index+wordDict.get(i).length());
                if (substring.equals(wordDict.get(i))){
                    stringBuilder.append(" ").append(wordDict.get(i));
                    process(index+wordDict.get(i).length(),s,wordDict,stringBuilder);
                    stringBuilder.delete(stringBuilder.length()-wordDict.get(i).length()-1,stringBuilder.length());
                }
            }
        }
    }
}
