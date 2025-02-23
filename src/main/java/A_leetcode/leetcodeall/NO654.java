package A_leetcode.leetcodeall;

public class NO654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0,nums.length-1,nums);
    }
    //在l到r范围上创建树，返回根节点
    public static TreeNode construct(int l,int r,int [] nums){
        if(l==r){
            return new TreeNode(nums[l]);
        }else if (l>r){
            return null;
        }
        int maxindex = l;
        int num = nums[l];
        for(int i = l+1;i<=r;i++){
            if(nums[i]>num){
                maxindex = i;
                num = nums[i];
            }
        }
        TreeNode root = new TreeNode(num);
        root.left = construct(l,maxindex-1,nums);
        root.right = construct(maxindex+1,r,nums);
        return root;
    }

    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}
