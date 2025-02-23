package A_leetcode.leetcodeall;

import java.util.Arrays;
import java.util.HashMap;

public class No1371 {

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }

    public static int findTheLongestSubstring(String s) {
            int [] map = new int[32];
            char [] chars = s.toCharArray();
            int sum = 0;
            int ans = 0;
            Arrays.fill(map,-2);
            map[0] = -1;
            for(int i = 0;i<chars.length;i++){
                if(chars[i]=='a'){
                    if((sum&(1<<4))>0){
                        //说明此时是1
                        sum = sum&15;
                    }else{
                        sum  = sum|1<<4;
                    }
                }else if(chars[i]=='e'){
                    if((sum&(1<<3))>0){
                        //说明此时是1
                        sum = sum&23;
                    }else{
                        sum  = sum|1<<3;
                    }
                }else if(chars[i]=='i'){
                    if((sum&(1<<2))>0){
                        //说明此时是1
                        sum = sum&27;
                    }else{
                        sum  = sum|1<<2;
                    }
                }else if(chars[i]=='o'){
                    // 11101
                    if((sum&(1<<1))>0){
                        //说明此时是1
                        sum = sum&29;
                    }else{
                        sum  = sum|1<<1;
                    }
                }else if(chars[i]=='u'){
                    // 11110
                    if((sum&(1))>0){
                        //说明此时是1
                        sum = sum&30;
                    }else{
                        sum  = sum|1;
                    }
                }
                if(map[sum]!=-2){
                    ans = Math.max(ans,i-map[sum]);
                }else{
                    map[sum] = i;
                }
            }
            return ans;
    }
}
