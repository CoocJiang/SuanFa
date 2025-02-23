package 二分查找;

public class 二分查找 {

    public static void main(String[] args) {
        int [] nums ={1,3,5,6};
        exist(nums,7);
    }


    //判断数字num是否存在与数组arr中
    public static int exist(int [] nums, int target){
        if (nums ==null){
            return 0;
        }
        int mid  = (nums.length-1)/2;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (target <nums[mid]){
                right = mid-1;
                mid=(right+left)/2;
            }else if (target >nums[mid]){
                left= mid+1;
                mid=(left+right)/2;
            }else {
                return mid;
            }
        }
        if (nums[mid]<target){
            return mid+1;
        }else {
            return mid-1;
        }
    }
}
