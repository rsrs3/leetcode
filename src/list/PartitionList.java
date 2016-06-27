package list;

/**
 * Created by rajat on 6/23/16.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smallHead = null, smallTail = null, bigHead = null, bigTail = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (smallHead == null) {
                    smallHead = curr;
                    smallTail = curr;
                } else {
                    smallTail.next = curr;
                    smallTail = smallTail.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = curr;
                    bigTail = curr;
                } else {
                    bigTail.next = curr;
                    bigTail = bigTail.next;
                }
            }
            curr = curr.next;
        }

        if (smallHead == null) return bigHead;
        smallTail.next = bigHead;
        if (bigHead != null) bigTail.next = null;
        return smallHead;
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode nHead = new PartitionList().partition(head, 3);
        ListNode runner = nHead;
        while (runner != null) {
            System.out.println(runner.val);
            runner = runner.next;
        }
    }
}
