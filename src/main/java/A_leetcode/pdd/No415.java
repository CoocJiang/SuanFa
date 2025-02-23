package A_leetcode.pdd;

public class No415 {
    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }
    public static String addStrings(String num1, String num2) {
        int l = num1.length()-1;
        int r = num2.length()-1;
        StringBuilder ans = new StringBuilder();
        int a1;
        int a2;
        char add = 0;
        while ((l>=0||r>=0)||add>0){
            a1 = (l < 0 ?'0': num1.charAt(l--)) - '0';
            a2 = (r < 0 ?'0':num2.charAt(r--) )- '0';
            int sum = a2+a1+add;
            if (sum<=9){
                add=0;
                char c = (char) (sum+'0');
                ans.insert(0,c);
            }else {
                add=1;
                sum-=10;
                char c = (char) (sum+'0');
                ans.insert(0,c);
            }
        }
        return ans.toString();
    }
}
