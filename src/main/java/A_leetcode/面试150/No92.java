package A_leetcode.面试150;

import java.util.Stack;

public class No92 {


     static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        reverseBetween(head,1,2);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
         if (head==null||head.next==null){
             return head;
         }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        //分两种情况，头节点在反转范围内，和不在反转范围
        if (left>1){
            //找到要反转前的一个位置
            for (int i = 1; i < left - 1; i++) {
                cur = cur.next;
            }
            //记录一下不再反转范围的左边
            ListNode zuo= cur;
            //现在cur就是要反转的位置
            cur = cur.next;
            //把要反转的全部押入栈
            for (int i = left; i <= right; i++) {
                stack.add(cur);
                cur=cur.next;
            }
            //现在cur是right之后的节点
            ListNode you = cur;
            //左边第一个毫无疑问出战
            zuo.next=stack.pop();
            cur = zuo.next;
            //依次弹出
            while (!stack.isEmpty()){
                cur.next= stack.pop();
                cur=cur.next;
            }
            cur.next = you;
            return head;
        }else {
            for (int i = left; i <= right; i++) {
                stack.add(cur);
                cur=cur.next;
            }
            ListNode you = cur;
            head=stack.pop();
            cur = head;
            while (!stack.isEmpty()){
                cur.next= stack.pop();
                cur=cur.next;
            }
            cur.next = you;
            return head;
        }
    }
}
