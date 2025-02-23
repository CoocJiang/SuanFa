package A_leetcode.leetcodeall;

public class No1299 {
    public static void main(String[] args) {

    }
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int max = -1;
        int temp;
        for(int i = length-1;i>=0;i--){
            temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        return arr;
    }
}
