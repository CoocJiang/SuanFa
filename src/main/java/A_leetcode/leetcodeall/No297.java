package A_leetcode.leetcodeall;

public class No297 {

 public static class TreeNode {
      int val;
     TreeNode right;
     TreeNode left;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        TreeNode cur = root;
        StringBuilder str = new StringBuilder();
        if (root!=null){
          process(root,str);
        }else {
            return "#";
        }
        return str.toString();
    }

    public static void process(TreeNode root,StringBuilder stringBuilder){
         stringBuilder.append(root.val).append(",");
         if (root.left!=null){
             process(root.left,stringBuilder);
         }else {
             stringBuilder.append("#,");
         }
        if (root.right!=null){
            process(root.right,stringBuilder);
        }else {
            stringBuilder.append("#,");
        }
    }
    static Integer index;
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        index = 0;
        return process1(split);
    }

    public static TreeNode process1(String[] s){
        if (index> s.length||s[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[index]));
        index++;
        root.left = process1(s);
        root.right = process1(s);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left=new TreeNode(2);
        TreeNode node3 =root.right = new TreeNode(3);
        node3.left=new TreeNode(4);
        node3.right= new TreeNode(5);
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize.val);
    }
}
