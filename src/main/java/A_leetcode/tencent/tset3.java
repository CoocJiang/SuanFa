package A_leetcode.tencent;

public class tset3 {


    public static void main(String[] args) {
        System.out.println(perfectPair(new int[]{25, 2, 1, 16}));
    }
    public static int perfectPair (int[] arr) {
        // write code here
        int count = 0;
        int n = arr.length;
        for (int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){
                if (is(arr[i]*arr[j])) count++;
            }
        }
        return count;
    }

    public static boolean is(int num){
        if (num<10){
            return true;
        }else {
            while (num>=10){
                if (num%10!=0){
                    return false;
                }
                num /= 10;
            }
            return true;
        }
    }
}
