package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class No3211 {

    public static void main(String[] args) {
        for (String validString : validStrings(3)) {
            System.out.println(validString);
        }
    }


    static List<String> ans ;
    public static List<String> validStrings(int n) {
        ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        if (n>1){
           process(stringBuilder,true,n);
        }else {
            ans.add("1");
            ans.add("0");
        }
        return ans;
    }

    private static void process(StringBuilder stringBuilder, boolean flag,int n) {
        if (stringBuilder.length()==n-1){
            if (flag){
                stringBuilder.append("0");
                ans.add(stringBuilder.toString());
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
            stringBuilder.append("1");
            ans.add(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }else {
            if (flag){
                stringBuilder.append("0");
                process(stringBuilder,false,n);
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
            stringBuilder.append("1");
            process(stringBuilder,true,n);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

        }
    }
}
