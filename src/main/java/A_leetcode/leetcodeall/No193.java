package A_leetcode.leetcodeall;

public class No193 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root,p,q);
    }
    public static TreeNode process(TreeNode root, TreeNode p, TreeNode q){

      //如果root夹在中间直接返回root
      if ((p.val<=root.val&&root.val<=q.val)||(p.val>=root.val&&root.val>=q.val)){
          return root;
      }

      if (p.val>root.val&&q.val> root.val){
         return process(root.right,q,p);
      }

     if (p.val<root.val&&q.val < root.val){
        return process(root.left,q,p);
     }
    return null;
    }
}
