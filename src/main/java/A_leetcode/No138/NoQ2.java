package A_leetcode.No138;

public class NoQ2 {
    public static void main(String[] args) {
        System.out.println(stringHash("mxz",3));
    }
    public static String stringHash(String s, int k) {
        int length = s.length();
        int l = length/k;
        int jian = k*'a';
        StringBuilder hashedChar = new StringBuilder();
        for (int i = 0;i<l;i++){
            int sum = 0;
            for (int j = 0;j<k;j++){
                sum+=s.charAt(j+i*k);
            }
            sum-=jian;
            sum = sum%26;
            char c = (char) (sum+'a');
            hashedChar.append(c);
        }
        return hashedChar.toString();
    }
}
