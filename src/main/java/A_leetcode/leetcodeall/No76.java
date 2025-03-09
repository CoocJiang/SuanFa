package A_leetcode.leetcodeall;

import java.util.*;

public class No76 {
    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow1(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i),1);
                set.add(t.charAt(i));
            }
        }
        char [] chars  = s.toCharArray();
        int left = 0;
        int right = 0;
        int [] ans = new int[2];
        int length = s.length();
        while(right<s.length()){
            if(map.containsKey(chars[right])){
                int a = map.get(chars[right]);
                map.put(chars[right],a-1);
                if((a-1)==0){
                    set.remove(chars[right]);
                    while(left<=right&&set.size()==0){
                        if((right-left)<length){
                            ans[0] = left;
                            ans[1] = right;
                            length = right-left;
                        }
                        if(left<=right&&map.containsKey(chars[left])){
                            int temp =  map.get(chars[left])+1;
                            map.put(chars[left],temp);
                            if(temp>0){
                                set.add(chars[left]);
                            }
                        }
                        left++;
                    }
                }
                right++;
            }else {
                right++;
            }
        }
        if(length<s.length()){
            return s.substring(ans[0],ans[1]+1);
        }else {
            return "";
        }
    }
    public static String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
       int [] map = new int [123];
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < t.length();i++){
                map[t.charAt(i)]++;
                set.add(t.charAt(i));
        }
        char [] chars  = s.toCharArray();
        int left = 0;
        int right = 0;
        int [] ans = new int[2];
        int length = s.length();
        while(right<s.length()){
            map[chars[right]]--;
            if(map[chars[right]]==0){
                set.remove(chars[right]);
                while(set.size()==0){
                    if((right-left)<length){
                        ans[0] = left;
                        ans[1] = right;
                        length = right-left;
                    }
                    map[chars[left]]++;
                    if(map[chars[left]]>0){
                        set.add(chars[left]);
                    }
                    left++;
                }
            }
            right++;
        }
        if(length<s.length()){
            return s.substring(ans[0],ans[1]+1);
        }else {
            return "";
        }
    }

    public static String minWindow2(String s, String t) {
        String result = "";
        int[] chars = new int[26];
        int right = 0;
        int left = 0;
        int length = s.length();
        int cnts = t.length();
        char[] charArray = s.toCharArray();
        for (char c : t.toCharArray()) {
            chars[c - 'A']++;
        }
        while (right < length) {
            if (chars[charArray[right] - 'A'] > 0) {
                cnts--;
            }
            chars[charArray[right] - 'A']--;
            right++;
            if (cnts <= 0) {
                while (chars[charArray[left] - 'A'] < 0) {
                    chars[charArray[left] - 'A']++;
                    left++;
                }
                if (result.equals("")||(right-left)<result.length()) {
                    result = s.substring(left,right);
                }
            }
        }
        return result;
    }

}

