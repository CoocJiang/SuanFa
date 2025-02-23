package A_leetcode.面试150;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.List;

public class No21 {


    static   public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
// 创建两个链表
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1,l2);
    }


    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 选择头节点
        ListNode head;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        ListNode cur = head;

        // 循环遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        // 将剩余未遍历完的节点连接到新链表的末尾
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null&&list2==null){
            return null;
        }
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        //选择头节点
        ListNode head;
        ListNode result;
        if (list1.val>list2.val ){
            head =list2;
            result = head;
            list2  = list2.next;
        }else {
            head =list1;
            result=head;
            list1 = list1.next;
        }
        while (list1!=null||list2!=null){
            if (list1!=null&&list2!=null){
                if (list1.val>list2.val ){
                    head.next = list2;
                    list2  = list2.next;
                    head=head.next;
                }else {
                    head.next =list1;
                    list1 = list1.next;
                    head=head.next;
                }
            }else if(list1==null){
                head.next= list2;
                break;
            } else if (list2==null) {
                head.next= list1;
                break;
            }
        }
        return result;
    }
}
