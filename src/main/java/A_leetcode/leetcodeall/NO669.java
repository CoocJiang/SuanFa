package A_leetcode.leetcodeall;

public class NO669 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        return process(root,low,high);
    }

    public static TreeNode process(TreeNode root, int low, int high){
        if (root.val<low){
            if (root.right!=null){
                root=process(root.right,low,high);
            }else {
                return null;
            }
        }else if(root.val>high){
            root = root.left;
            if (root!=null){
                root=process(root,low,high);
            }
        }
            if (root.left!=null){
                root.left=process(root.left,low,high);
            }
            if (root.right!=null){
                root.right =process(root.right,low,high);
            }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        trimBST(root,1,2);
    }
}
