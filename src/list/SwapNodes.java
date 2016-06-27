package list;

/**
 * Created by rajat on 6/22/16.
 */
public class SwapNodes {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dNode = new ListNode(-1);
        dNode.next = head;
        ListNode pre = dNode, curr = head, next;
        while (curr != null && curr.next != null) {
            next = curr.next;
            ListNode tmp = next.next;
            pre.next = next;
            next.next = curr;
            curr.next = tmp;
            curr = tmp;
            pre = curr;
        }
        return dNode.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
