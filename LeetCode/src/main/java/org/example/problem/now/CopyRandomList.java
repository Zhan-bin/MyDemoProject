package org.example.problem.now;

import org.example.problem.common.Node;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node p = head;
        while (p != null) {
            Node next = p.next;
            p.next = new Node(p.val);
            p.next.next = next;
            p = next;
        }

        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        Node newHead = head.next;
        p = head;
        while (p.next != null) {
            Node next = p.next;
            p.next = next.next;
            p = next;
        }

        return newHead;
    }
}
