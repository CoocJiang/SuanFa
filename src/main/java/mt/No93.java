package mt;

import java.util.ArrayList;
import java.util.List;

public class No93 {
    public static void main(String[] args) {
        restoreIpAddresses("101023").stream().forEach(System.out::println);
    }
    static List<String> ans;
    public static List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        process(new StringBuilder(),0,length-1,3, s);
        return ans;
    }

    public static void process(StringBuilder stringBuilder,int l,int r,int need,String s){
        if (r-l<need||r-l>((need)*3+2)||need<0){
            return;
        } else if (s.charAt(l)=='0'){
            if (need>0){
                stringBuilder.append("0").append(".");
                process(stringBuilder,l+1,r,need-1,s);
                stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
            }else {
                if (l<r){
                    return;
                }else {
                    stringBuilder.append("0");
                    ans.add(stringBuilder.toString());
                    stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                }
            }
        }else if (need==0){
            String cur = s.substring(l,r+1);
            if (Integer.parseInt(cur)<=255){
                stringBuilder.append(cur);
                ans.add(stringBuilder.toString());
                stringBuilder.delete(stringBuilder.length()-(r+1-l),stringBuilder.length());
            }
        }else {
            for (int i = l+1;i<l+4&&i<=r;i++){
                String cur = s.substring(l,i);
                if (Integer.parseInt(cur)>255){
                    break;
                }
                stringBuilder.append(cur).append(".");
                process(stringBuilder,i,r,need-1,s);
                stringBuilder.delete(stringBuilder.length()-(i+1-l),stringBuilder.length());
            }
        }
    }
}
