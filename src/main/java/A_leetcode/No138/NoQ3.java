package A_leetcode.No138;

import java.util.HashSet;
import java.util.Set;

public class NoQ3 {
    public static void main(String[] args) {
        System.out.println(countGoodIntegers(5, 6));
    }
    public static long countGoodIntegers(int n, int k) {
        StringBuilder s= new StringBuilder();
        for (int i = 0;i<n;i++){
            s.append("9");
        }
        long count = 0;
        int num = Integer.parseInt(s.toString());
        for (int i = 0;i<=num;i = i+k){
            if (ishuiwen(i)){
                String s1 = String.valueOf(i);
                count+=countValidPermutations(s1,k);
            }
        }
        return count;
    }

    public static boolean ishuiwen(int nums){
        String s = String.valueOf(nums);
        int l = 0;
        int r = s.length()-1;
        if (r<1){
            return true;
        }else {
            while (l<r){
                if (s.charAt(l)==s.charAt(r)) {
                    l++;
                    r--;
                }else {
                    return false;
                }
            }
            return true;
        }
    }

    public static int countValidPermutations(String s, int k) {
        Set<String> permutations = new HashSet<>();
        generatePermutations(s.toCharArray(), 0, permutations);
        int count = 0;
        for (String perm : permutations) {
            if (!perm.startsWith("0") && Integer.parseInt(perm) % k == 0) {
                count++;
            }
        }
        return count;
    }

    private static void generatePermutations(char[] array, int start, Set<String> result) {
        if (start >= array.length) {
            result.add(new String(array));
        } else {
            Set<Character> seen = new HashSet<>();
            for (int i = start; i < array.length; i++) {
                if (!seen.contains(array[i])) {
                    seen.add(array[i]);
                    swap(array, start, i);
                    generatePermutations(array, start + 1, result);
                    swap(array, start, i); // backtrack
                }
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
