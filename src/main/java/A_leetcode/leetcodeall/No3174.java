package A_leetcode.leetcodeall;

public class No3174 {

    public String clearDigits(String s) {
        char [] chars = s.toCharArray();
        int r = chars.length-1;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(r>=0){
            if ('0'<=chars[r]&&chars[r]<='9'){
                count++;
            } else if (chars[r]>='a'&&chars[r]<='z'){
                if (count>0){
                    count--;
                }else {
                    stringBuilder.insert(0,chars[r]);
                }
            }
            r--;
        }
        return stringBuilder.toString();
    }
}
