package A_leetcode.pdd;

public class No43 {


    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        String ans = "0";
        for (int i = n-1;i>=0;i--){
            StringBuilder stringBuilder = new StringBuilder();
            int num = num1.charAt(i)-'0';
            for (int j=n-1;j>i;j--){
                stringBuilder.insert(0,"0");
            }
            int sum = 0;
            int add = 0;
            for (int j = m-1;j>=0;j--){
                int nums2 = num2.charAt(j)-'0';
                sum = nums2*num+add;
                if (sum>=10){
                    add = sum/10;
                }else {
                    add = 0;
                }
                stringBuilder.insert(0,sum%10);
            }
            if (add>0){
                stringBuilder.insert(0,add);
            }
            ans = addStrings(ans,stringBuilder.toString());
        }
        return ans;
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
