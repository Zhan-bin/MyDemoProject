package org.example.problem.history;

import org.example.problem.common.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            if (p == null) {
                return null;
            }

            p = p.next;
        }

        ListNode q = new ListNode();
        ListNode res = q;
        q.next = head;
        while (p != null) {
            p = p.next;
            q = q.next;
        }

        if (q.next != null) {
            q.next = q.next.next;
        }

        return res.next;
    }
}
