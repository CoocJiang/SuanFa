package wuba;

public class No2 {


    public static int StringSplit (String str) {
        // write code here
        int cntsA = 0;
        int cntsB = 0;
        int allB = 0;
        int allA = 0;
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='a'){
                allA++;
            }else {
                allB++;
            }
        }
        int max = cntsA+allB-cntsB;
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='a'){
                cntsA++;
            }else {
                cntsB++;
            }
            max = Math.max((cntsA+allB-cntsB),max);
        }
        return max;
    }
}
