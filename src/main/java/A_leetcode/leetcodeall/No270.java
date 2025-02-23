package A_leetcode.leetcodeall;

import javax.security.auth.login.AccountLockedException;

public class No270 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(closestValue(root, 3.4));
    }
    static int ans;
    public  static int closestValue(TreeNode root, double target) {
        ans = -1;
        process(target,root);
        return ans;
    }


    public static void process(double target,TreeNode treeNode){
        if (treeNode==null){
            return;
        }else {
            if (treeNode.left!=null){
                process(target,treeNode.left);
            }
            if (Math.abs(treeNode.val-target)<Math.abs(ans-target)||ans==-1){
                ans = treeNode.val;
            }
            if (treeNode.right!=null){
                process(target,treeNode.right);
            }
        }
    }
}
