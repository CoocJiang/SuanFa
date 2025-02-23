package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No6 {

    public static void main(String[] args) {
        String s ="PAYPALISHIRING";
        System.out.println(convert(s,4));
    }



    public static String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int j = 0;j<numRows;j++){
            if (j==0||j==numRows-1){
                for (int i=j;i<chars.length;i=i+numRows-2+numRows){
                    builder.append(chars[i]);
                }
            }else {
                for (int i=j;i<chars.length;i=j*2+i){
                    builder.append(chars[i]);
                    i=(numRows-j-1)*2+i;
                    if (i<chars.length) {
                        builder.append(chars[i]);
                    }
                }
            }
        }
        return builder.toString();
    }

}
