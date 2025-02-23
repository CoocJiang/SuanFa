package A_leetcode.leetcodeall;

public class No682 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
    static int score ;
    static int cur;
    public static int calPoints(String[] operations) {
        int l = 0;
        score = 0;
        int n = operations.length;
        int [] scores = new int[n];
        for (String num:operations){
            if (num.equals("+")){
                cur=scores[l-1]+scores[l-2];
                scores[l++] = cur;
                score+=cur;
            }else if (num.equals("D")){
                cur=scores[l-1]*2;
                scores[l++] = cur;
                score+=cur;
            } else if (num.equals("C")) {
                cur = scores[--l];
                score-=cur;
            }else {
                cur=Integer.parseInt(num);
                scores[l++] = cur;
                score+=cur;
            }
        }
        return score;
    }
}
