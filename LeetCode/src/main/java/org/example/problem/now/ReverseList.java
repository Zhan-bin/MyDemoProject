package org.example.problem.now;

import org.example.problem.common.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, curr = head, next = curr.next;
        while (next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }

        curr.next = pre;  // 边界值处理，易错
        return curr;
    }
}
