package hash;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by rajat on 6/23/16.
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((first, second) -> {
            if (first.val < second.val) return -1;
            else if (first.val > second.val) return 1;
            else return 0;
        });

        for (ListNode node : lists) {
            if (node != null) priorityQueue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode tNode = priorityQueue.poll();
            tail.next = tNode;
            if (tNode.next != null) priorityQueue.offer(tNode.next);
            tail = tail.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("a,b,c,".split(",")));
    }
}
