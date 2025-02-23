package A_leetcode.leetcodeall;

public class No538 {



    public static TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    static int sum ;
    public static void dfs(TreeNode root){
        if (root.right!=null){
             dfs(root.right);
        }

        root.val += sum;
        sum = root.val;

        if (root.left!=null){
           dfs(root.left);
        }

    }

}
