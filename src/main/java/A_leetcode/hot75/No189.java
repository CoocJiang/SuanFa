package A_leetcode.hot75;

public class No189 {
    public static void main(String[] args) {
        int [] n = new int[]{-1,-100,3,99};
        rotate(n,2);
        for (int i:n){
            System.out.println(i);
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int cnts = 0;
        int num = nums[0];
        int index = 0;
        while(cnts<n){
            index = (index+k)%n;
            int temp = nums[index];
            nums[index] = num;
            num = temp;
            cnts++;
        }
    }

}
