package A_leetcode.面试150;

public class No33 {
    public static void main(String[] args) {
        int [] nums = {3,1};
        System.out.println(search1(nums, 1));
    }



    public static int search(int[] nums, int target) {
        if (nums ==null){
            return 0;
        }
        int mid  = (nums.length-1)/2;
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            //说明 mid到right还是正常的
            if (nums[mid]<=nums[right]){
                if (target>nums[mid]){
                    if (target>nums[right]){
                        right=mid-1;
                        mid=(left+right)/2;
                    }else if (target<nums[right]){
                        left=mid+1;
                        mid=(left+right)/2;
                    }else {
                        return right;
                    }
                }else if (target<nums[mid]){
                    right=mid-1;
                    mid=(left+right)/2;
                }
                else {
                    return mid;
                }
            }//说明left到mid是正常的
            else  if (nums[mid]>nums[right]){
                    if (target<nums[mid]){
                        if (target>nums[right]){
                            right = mid-1;
                            mid  = (left+right)/2;
                        }else if (target<nums[right]){
                            left = mid+1;
                            mid  = (left+right)/2;
                        }else {
                            return right;
                        }
                    }else if(target>nums[mid]) {
                        left = mid+1;
                        mid  = (left+right)/2;
                    }
                    else {
                        return mid;
                    }
                }
            }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int l  = 0;
        int n = nums.length;
        int r = n-1;
        while(l<=r){
            int m = l+((r-l)>>>1);
            if(target>nums[m]){
                if(nums[m]>nums[r]){
                    l = m+1;
                }else{
                    //nums[r]>nums[m]
                    if(nums[r]>=target){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }
            }else if(target<nums[m]){
                if(nums[m]<nums[r]){
                    r = m - 1;
                }else{
                    //nums[m]>nums[r]
                    if(nums[r]>=target){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }
            }else{
                return m;
            }
        }
        return -1;
    }
}
