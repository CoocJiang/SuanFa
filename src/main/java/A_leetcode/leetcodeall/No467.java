package A_leetcode.leetcodeall;

import java.util.Arrays;

public class No467 {

    static int [] arr = new int [26];
    public int findSubstringInWraproundString(String s) {
        Arrays.fill(arr,0);
        char [] chars = s.toCharArray();
        arr[chars[0]-'a'] = 1;
        int length = 1;
        char cur = chars[0];
        for(int i = 1;i<chars.length;i++){
            if(chars[i]==cur+1||(cur=='z'&&chars[i]=='a')){
                length++;
            }else{
                length=1;
            }
            cur = chars[i];
            int index = cur-'a';
            arr[index] = Math.max(arr[index],length);
        }
        int ans = 0;
        for(int i:arr){
            ans+=i;
        }
        return ans;
    }
}
