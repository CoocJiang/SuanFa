package A_leetcode.leetcodeall;

public class No285 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        inorderSuccessor(root,root.left);
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ans = null;
        process(root,p);
        return ans;
    }
    static TreeNode ans;
    static TreeNode pre;
    public static void process(TreeNode cur,TreeNode p){
        if (cur.left!=null){
            process(cur.left,p);
        }
        if (pre == p){
            ans = cur;
        }
        pre = cur;
        if (cur.right!=null){
            process(cur.right,p);
        }
    }
}
