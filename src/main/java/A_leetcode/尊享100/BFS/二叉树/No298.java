package A_leetcode.尊享100.BFS.二叉树;

public class No298 {

static public class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
//        root.right.right.right.right = new TreeNode(6);
        System.out.println(longestConsecutive(root));
    }
    public static int longestConsecutive(TreeNode root) {
        if (root==null){
            return 0;
        }
        process(root);
        return max;
    }

    static int max = 0;

    private static int process(TreeNode node) {
        int p1 = 1;
        int p2 = 1;
        if (node.left!=null){
             p1 = process(node.left);
            if (node.left.val-1==node.val){
                p1++;
            }else{
                p1 = 1;
            }
        }
        if (node.right!=null){
            p2 = process(node.right);
            if (node.right.val-1==node.val){
                p2++;
            }else {
                p2 = 1;
            }
        }
        int ans = Math.max(p1,p2);
        max= Math.max(max,ans);
        return ans;
    }
}
