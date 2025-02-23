package A_leetcode.tencent;

public class No2415 {

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
        // 创建树节点
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node21 = new TreeNode(21);
        TreeNode node34 = new TreeNode(34);
        TreeNode node3 = new TreeNode(3, node8, node13);
        TreeNode node5 = new TreeNode(5, node21, node34);
        TreeNode root = new TreeNode(2, node3, node5);

        // 可以在这里添加代码来使用这个树，例如遍历或其他操作
        reverseOddLevels(root);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
         process(root.left,root.right,1);
         return root;
    }

    private static void process(TreeNode left,TreeNode right, int i) {
        if (left==null){
            return;
        }else if (i%2==1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        process(left.left,left.right,i+1);
        process(right.left,right.right,i+1);
    }


//    public static void swap(TreeNode left,TreeNode right){
//        TreeNode temp = left.left;
//        left.left = right.left;
//        right.left = temp;
//
//
//        temp = left.right;
//        left.right = right.right;
//        right.right = temp;
//    }

}
