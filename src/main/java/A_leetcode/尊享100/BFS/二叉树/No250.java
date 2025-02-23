package A_leetcode.尊享100.BFS.二叉树;

public class No250 {

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

    static public class result{
      boolean is;
      int num;

      int cnt;

        public result(boolean is, int num,int cnt) {
            this.is = is;
            this.num = num;
            this.cnt = cnt;
        }
    }
    static int count;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            count = 0;
             process(root);
             return count;
        }
    }

    private result process(TreeNode root) {
        if (root==null){
            return new result(true,1001,0);
        }else {
            result p1 = process(root.left);
            result p2 = process(root.right);
            if (p1.is&& p2.is){
                if (p1.num==1001){
                    if (p2.num==1001||p2.num==root.val){
                        int newcount = p1.cnt+p2.cnt+1;
                        count++;
                        return new result(true,root.val,newcount);
                    }else {
                        return new result(false,0,0);
                    }
                }else {
                    if (p2.num==1001&&p1.num==root.val||(p1.num == p2.num&&p1.num == root.val)){
                        int newcount = p1.cnt+p2.cnt+1;
                        count++;
                        return new result(true,root.val,newcount);
                    }else{
                        return new result(false,0,0);
                    }
                }
            }else {
                return p1.is ? p2.is ? new result(false,0,0):p2:p1;
            }
        }
    }
}
