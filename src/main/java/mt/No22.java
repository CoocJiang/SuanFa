package mt;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    public static void main(String[] args) {
        generateParenthesis(3).stream().forEach(System.out::println);
    }
    static List<String> ans;
    public static List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        ans = new ArrayList<>();
        preocess(left,right,new StringBuilder());
        return ans;
    }

    private static void preocess(int left, int right,StringBuilder stringBuilder) {
        if (left==0&&right==0){
            ans.add(stringBuilder.toString());
        }else {
            if (left>0){
                preocess(left-1,right,stringBuilder.append("("));
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
            if (right>0&&right>left){
                preocess(left,right-1,stringBuilder.append(")"));
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
        }
    }


}
