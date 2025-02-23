package A_leetcode.面试150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int [] s1 = new int[26];
        int [] t1 = new int[26];
        int index1;
        int index2;
        for (int i=0;i<s.length();i++ ){
             index1 = s.charAt(i)-'a';
             index2 = t.charAt(i)-'a';
             s1[index1]++;
             t1[index2]++;
        }
      for (int i=0;i<s1.length;i++){
          if (s1[i]!=t1[i]){
              return false;
          }
      }
        return true;
    }
}
