package org.example.problem.history;

import org.example.problem.common.ListNode;

/**
 * 0 0 0 0
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = findMidNode(head);
        ListNode right = midNode.next;
        ListNode left = head;
        midNode.next = null;

        right = sortList(right);
        left = sortList(left);

        return merge(left, right);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        }

        if (head2 != null) {
            curr.next = head2;
        }

        return head.next;
    }

    public ListNode findMidNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow =head;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
