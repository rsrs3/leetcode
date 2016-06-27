package list;

/**
 * Created by rajat on 6/23/16.
 */
public class KGroupReverse {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head, next;
        while (curr != null) {
            ListNode runner = curr;
            int walk = k;
            while (runner != null && runner.next != null && walk > 1) {
                runner = runner.next;
                walk--;
            }

            if (walk > 1) break;

            next = runner.next;
            ListNode[] result = reverse(curr, runner);
            pre.next = result[0];
            result[1].next = next;
            pre = result[1];
            curr = next;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = null, curr = head, next;
        ListNode newHead, newTail = null;
        ListNode[] result = new ListNode[2];
        while (curr != tail) {
            next = curr.next;
            if (pre == null) {
                newTail = curr;
            } else {
                curr.next = pre;
            }
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        newHead = curr;
        result[0] = newHead;
        result[1] = newTail;
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        ListNode result = new KGroupReverse().reverseKGroup(head, 1);
        ListNode runner = result;
        while (runner != null) {
            System.out.println(runner.val);
            runner = runner.next;
        }
    }
}
