package A_leetcode.leetcodeall;

public class No962 {
    public static void main(String[] args) {

        int [] nums = {0,1};
        System.out.println(maxWidthRamp(nums));
    }

    static int[] small = new int[50000];

    static int[] big = new int[50000];

    static  int max;

    static int r;

    static int right;

    //手动实现单调栈
    public static int maxWidthRamp1(int[] nums) {
        max = 0;
        r = 0;
        right=0;
        for (int i=0;i< nums.length;i++){
            //循环遍历，把小的数值存入栈中，遇到0直接结束循环，因为0已经是最小值了，如果数值比栈中的小就存入
            if (r==0||nums[small[r-1]]>nums[i]){
                small[r++] = i;
                if (nums[i]==0){
                    break;
                }
            }
        }
        for (int i=nums.length-1;i>=0;i--){
            //用一个单调递增栈实现从后向前遍历，如果此时的数比栈里的还小，就没必要遍历了，
            if (right==0||nums[i]>nums[big[right-1]]){
                big[right++] = i;
                while (r>0&&nums[i]>=nums[small[r-1]]){
                    max = Math.max(i-small[r-1],max);
                    r--;
                }
            }
        }
        return max;
    }

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int [] qian = new int [n];
        int [] hou = new int [n];
        int l = 1;
        int r = n-2;
        hou [n-1] = n-1;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[qian[l-1]]){
                qian[l++] = i;
            }
            if(nums[n-i]>nums[hou[r+1]]){
                hou[r--] = n-i;
            }
        }
        int ans = 0;
        for(int i = n-1,j = l-1;i>r;i--){
            while(j>=0&&nums[hou[i]]-nums[qian[j]]>=0){
                ans =Math.max(ans, hou[i]-qian[j]);
                j--;
            }
        }
        return ans;
    }
}
