package list;

/**
 * Created by rajat on 6/23/16.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int l = length(head);
        if (k >= l) {
            k = k % l;
        }
        ListNode nHead = head;
        if (k != 0) {
            ListNode slow = head, fast = head;
            while (k > 0) {
                fast = fast.next;
                k--;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            nHead = slow.next;
            slow.next = null;
            fast.next = head;
        }
        return nHead;
    }

    private int length(ListNode head) {
        int l = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            l++;
        }
        return l;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
