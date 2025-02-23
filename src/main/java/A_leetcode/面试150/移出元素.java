package A_leetcode.面试150;

public class 移出元素 {
    public static void main(String[] args) {
        int nums [] = {0,1,2,2,3,0,4,2};
        int val = 2;
        int n = 0;
        int j = 0;
        for (int i : nums){
            if (i ==val){
                n++;
            }else {
                nums[j]=i;
                j++;
            }
        }
        for (int i : nums){
            System.out.println(i);
        }
    }
}

