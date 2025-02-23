package mt;

import java.util.ArrayList;
import java.util.List;

public class No241 {

    public static void main(String[] args) {
        diffWaysToCompute("11").forEach(System.out::println);
    }
    static  List<String> str;

    public static List<Integer> diffWaysToCompute(String expression) {
        str = new ArrayList<>();
        char[] chars = expression.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='*'){
                str.add("*");
            } else if (chars[i]=='-') {
                str.add("-");
            }else if (chars[i]=='+') {
                str.add("+");
            }else {
                if (i+1<chars.length){
                    if (chars[i+1]!='*'&&chars[i+1]!='-'&&chars[i+1]!='+'){
                        str.add(""+(chars[i])+ chars[i + 1]);
                    }else {
                        str.add(String.valueOf(chars[i]));
                        str.add(String.valueOf(chars[i+1]));
                    }
                    i++;
                }else {
                    str.add(""+(chars[i]));
                }
            }
        }
        int length = str.size();
        List<Integer> ans = process(0,length-1);
        return ans;
    }

    private static List<Integer> process(int start, int end) {
        List<Integer> list = new ArrayList<>();
        if (end==start){
            list.add(Integer.parseInt(str.get(start)));
        }else {
            for (int mid = start;mid<end;mid=mid+2){
                List<Integer> p1 = process(start,mid);
                List<Integer> p2 = process(mid+2,end);
                if (str.get(mid+1).equals("+")){
                    for (int pp1:p1){
                        for (int pp2:p2){
                            list.add(pp1+pp2);
                        }
                    }
                } else if (str.get(mid+1).equals("-")) {
                    for (int pp1:p1){
                        for (int pp2:p2){
                            list.add(pp1-pp2);
                        }
                    }
                }else {
                    for (int pp1:p1){
                        for (int pp2:p2){
                            list.add(pp1*pp2);
                        }
                    }
                }
            }
        }
        return list;
    }


}
