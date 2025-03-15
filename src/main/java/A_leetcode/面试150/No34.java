package A_leetcode.面试150;

public class No34 {

    public static void main(String[] args) {
        int [] nums = {2,2};
        System.out.println(searchRange3(nums,1));
    }


    public static int[] searchRange1(int[] nums, int target) {
        int [] ans =  new int [2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums==null){
            return ans;
        }
        int begin = 0;
        int end  = 0;
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            if (target<nums[mid]){
                right = mid-1;
                mid = (left+right)/2;
            }else if (target>nums[mid]){
                left = mid+1;
                mid = (left+right)/2;
            }else {
                ans[0] = process(nums,mid);
                ans[1] = process2(nums,mid);
                break;
            }
        }
        return ans;
    }

    public static int process(int[] nums,int index){
        int left = 0;
        int right = index;
        int targer = nums[right];
        int mid = (left+right)/2;
        int begin = right;
        while (left<=right){
            if (nums[mid]<targer){
                left = mid+1;
                mid = (right+left)/2;
            }else {
                begin = mid;
                right = mid-1;
                mid=(left+right)/2;
            }
        }
        return begin;
    }

    public static int process2(int[] nums,int index){
        int left = index;
        int right = nums.length-1;
        int targer = nums[index];
        int mid = (left+right)/2;
        int end = index;
        while (left<=right){
            if (nums[mid]>targer){
                right = mid-1;
                mid = (right+left)/2;
            }else {
                end = mid;
                left = mid+1;
                mid=(left+right)/2;
            }
        }
        return end;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]<=target){
                l=mid+1;
            }else {
                r = mid-1;
            }
        }
        int right = l-1;
        l = 0;
        r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]<target){
                l=mid+1;
            }else {
                r = mid-1;
            }
        }
        int left = r+1;
        if (left>right||nums[left]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }


    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int left  =  -1;
        int right = -1;
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]<target){
                l=mid+1;
            }else {
                left = mid;
                r = mid-1;
            }
        }
        l = 0;
        r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]<=target){
                right = mid;
                l=mid+1;
            }else {
                r = mid-1;
            }
        };
        if (left>right||left ==-1||nums[left]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }


    public static int[] searchRange3(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int length = nums.length;
        if (length < 1) return ans;
        int right = length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(left-1>=0){
            ans[1] = nums[left - 1] == target ? left - 1 : -1;
        }
        right = length - 1;
        left = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (right+1<length){
            ans[0] = nums[right + 1] == target ? right + 1 : -1;
        }
        return ans;
    }
}
