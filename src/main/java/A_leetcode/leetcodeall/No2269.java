package A_leetcode.leetcodeall;

public class No2269 {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(430043, 2));
    }
    public static int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int len = str.length();
        int ans = 0;
        int number = 0;
        for (int i = 0; i <= len-k; i++) {
            String sub = str.substring(i, i+k);
            number = Integer.parseInt(sub);
            if (number!=0&&num%number==0) ans++;
        }
        return ans;
    }
}
