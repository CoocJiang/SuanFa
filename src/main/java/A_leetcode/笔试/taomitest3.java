package A_leetcode.笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class taomitest3 {


    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList (ListNode head) {
        // write code here
        List<Integer> ans = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            ans.add(cur.val);
            cur=cur.next;
        }
        Collections.sort(ans);
        cur=head;
        int i=0;
        while (cur!=null){
            cur.val=ans.get(i);
            i++;
            cur=cur.next;
        }
        return head;
    }
}
